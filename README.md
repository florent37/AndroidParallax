# AndroidParallax

<a href="https://play.google.com/store/apps/details?id=com.github.florent37.florent.champigny">
  <img alt="Android app on Google Play" src="https://developer.android.com/images/brand/en_app_rgb_wo_45.png" />
</a>

Parallax on Android in the simplest way

[![Video](http://i.giphy.com/3o85xJJNrvTdxHXd9C.gif)](https://youtu.be/0b3Nr5kW-Vw)

<a href="https://play.google.com/store/apps/details?id=com.github.florent37.parallax.sample">
  <img alt="Android app on Google Play" src="https://developer.android.com/images/brand/en_app_rgb_wo_45.png" />
</a>

Download
--------

```groovy
compile ('com.github.florent37:androidparallax:1.0.1@aar'){
        transitive=true
}
```

Usage
--------

Simply replace your ScrollView with a **com.github.florent37.parallax.ScrollView**

Then add a **parallax=FLOAT_VALUE** into your view's **tag**

```xml
<com.github.florent37.parallax.ScrollView
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    >

    <!-- ...your usual views... -->

    <ImageView
        android:layout_width="match_parent"
        android:layout_height="200dp"
        android:scaleType="centerCrop"
        android:src="@drawable/background"

        android:tag="parallax=0.3" />

    <TextView
        style="@style/MyTitle"
        android:layout_width="match_parent"
        android:layout_height="160dp"
        android:gravity="center"
        android:text="My awesome title"

        android:tag="parallax=0.5" />

    <!-- ...your usual views... -->

</com.github.florent37.parallax.ScrollView>
```

And no additionnal lines into the activity !

```java
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

}
```

ParallaxView
--------

If you don't want to play with the **android:tag** attributes, then you cas simple surround your view with a ParallaxView.

A ParallaxView can move vertically of horizontally
Parallax attributes defines a parallax factor for this view

- parallaxVertical < 0 : the view will move slower than the scroll
- parallaxVertical > 0 : the view will move faster than the scroll

```xml
<com.github.florent37.parallax.ParallaxView
         android:layout_width="match_parent"
         android:layout_height="wrap_content"

         app:parallaxVertical="1.1"

         >

         <!-- Your View -->

</com.github.florent37.parallax.ScrollView>
```

Horizontal translation

- parallaxHorizontal < 0 : the view will move to the right
- parallaxHorizontal > 0 : the view will move to the left

```xml
<com.github.florent37.parallax.ParallaxView
         android:layout_width="match_parent"
         android:layout_height="wrap_content"

         app:parallaxHorizontal="1.1"

         >

          <!-- Your View -->

</com.github.florent37.parallax.ScrollView>
```


TODO
--------

- Add RecyclerView Parallax
- Add fading / parallax effect on a toolbar

Community
--------

Looking for contributors, feel free to fork !


Credits
-------

Author: Florent Champigny

<a href="https://play.google.com/store/apps/details?id=com.github.florent37.florent.champigny">
  <img alt="Android app on Google Play" src="https://developer.android.com/images/brand/en_app_rgb_wo_45.png" />
</a>
<a href="https://plus.google.com/+florentchampigny">
  <img alt="Follow me on Google+"
       src="https://raw.githubusercontent.com/florent37/DaVinci/master/mobile/src/main/res/drawable-hdpi/gplus.png" />
</a>
<a href="https://twitter.com/florent_champ">
  <img alt="Follow me on Twitter"
       src="https://raw.githubusercontent.com/florent37/DaVinci/master/mobile/src/main/res/drawable-hdpi/twitter.png" />
</a>
<a href="https://www.linkedin.com/profile/view?id=297860624">
  <img alt="Follow me on LinkedIn"
       src="https://raw.githubusercontent.com/florent37/DaVinci/master/mobile/src/main/res/drawable-hdpi/linkedin.png" />
</a>

License
--------

    Copyright 2015 florent37, Inc.

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
