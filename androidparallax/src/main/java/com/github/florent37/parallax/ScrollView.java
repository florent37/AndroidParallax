package com.github.florent37.parallax;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

import com.github.ksoichiro.android.observablescrollview.ObservableScrollView;
import com.github.ksoichiro.android.observablescrollview.ObservableScrollViewCallbacks;
import com.github.ksoichiro.android.observablescrollview.ScrollState;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by florentchampigny on 21/07/15.
 */
public class ScrollView extends ObservableScrollView {

    List<ParallaxView> viewsToMove = new ArrayList<>();
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
        if (view instanceof ParallaxView)
            viewsToMove.add(ParallaxView.class.cast(view));
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
                for (int i = 0; i < count; ++i) {
                    ParallaxView view = viewsToMove.get(i);
                    view.onParallax(offset);
                }
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
