package com.github.florent37.parallax;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

import com.github.ksoichiro.android.observablescrollview.ObservableScrollView;
import com.github.ksoichiro.android.observablescrollview.ObservableScrollViewCallbacks;
import com.github.ksoichiro.android.observablescrollview.ScrollState;
import com.nineoldandroids.view.ViewHelper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by florentchampigny on 21/07/15.
 */
public class ScrollView extends ObservableScrollView {

    List<ParallaxViewHolder> viewsToMove = new ArrayList<>();
    ObservableScrollViewCallbacks callbacks;

    public ScrollView(Context context) {
        super(context);
    }

    public ScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ScrollView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    protected void findParallaxViews(View view) {

        //view surrounded by ParallaxView
        if (view instanceof ParallaxView)
            viewsToMove.add(new ParallaxViewHolder(ParallaxView.class.cast(view)));

        //view contains android:tag="parallax=0.5"
        else if(view.getTag() != null && view.getTag().toString() != null && !view.getTag().toString().trim().isEmpty()){
            String[] subTags = view.getTag().toString().trim().split(";");
            for(String tag : subTags) {
                if (tag.contains("parallax=")) {
                    String floatString = tag.substring(tag.indexOf("=") + 1);
                    try {
                        Float value = Float.parseFloat(floatString);
                        viewsToMove.add(new ParallaxViewHolder(view, value));
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        else if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup)view;
            for (int i = 0; i < viewGroup.getChildCount(); ++i) {
                findParallaxViews(viewGroup.getChildAt(i));
            }
        }
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

        findParallaxViews(getChildAt(0));

        super.setScrollViewCallbacks(new ObservableScrollViewCallbacks() {
            @Override
            public void onScrollChanged(int offset, boolean b, boolean b1) {
                if (callbacks != null)
                    callbacks.onScrollChanged(offset, b, b1);

                int count = viewsToMove.size();
                for (int i = 0; i < count; ++i)
                    viewsToMove.get(i).onParallax(offset);

            }

            @Override
            public void onDownMotionEvent() {
                if (callbacks != null) callbacks.onDownMotionEvent();
            }

            @Override
            public void onUpOrCancelMotionEvent(ScrollState scrollState) {
                if (callbacks != null) callbacks.onUpOrCancelMotionEvent(scrollState);
            }
        });
    }

    @Override
    public void setScrollViewCallbacks(ObservableScrollViewCallbacks listener) {
        this.callbacks = listener;
    }
}
