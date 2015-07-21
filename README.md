# AndroidParallax
Parallax on Android in the simplest way

[![Video](http://i.giphy.com/3o85xJJNrvTdxHXd9C.gif)](https://youtu.be/0b3Nr5kW-Vw)

Download
--------

In your build.gradle [![Download](https://api.bintray.com/packages/florent37/maven/AndroidParallax/images/download.svg)](https://bintray.com/florent37/maven/AndroidParallax/_latestVersion)
```groovy
compile 'com.github.florent37:androidparallax:1.0.0@aar'
```

Usage
--------

Simply replace your ScrollView with a **com.github.florent37.parallax.ScrollView**

Then surround your moving views with a **com.github.florent37.parallax.ParallaxView**

```xml
<com.github.florent37.parallax.ScrollView
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    >

    <!-- ...your usual views... -->

    <com.github.florent37.parallax.ParallaxView
         android:layout_width="match_parent"
         android:layout_height="wrap_content"
         app:parallaxVertical="0.3">

         <!-- this view will have parallax effect -->
         <ImageView
             android:layout_width="match_parent"
             android:layout_height="200dp"
             android:scaleType="centerCrop"
             android:src="@drawable/background" />

    </com.github.florent37.parallax.ParallaxView>

    <com.github.florent37.parallax.ParallaxView
        android:layout_width="match_parent"
        android:layout_height="160dp"
        app:parallaxVertical="0.5">

        <!-- this view will have parallax effect -->
        <TextView
            android:layout_gravity="center"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="My awesome title"
            style="@style/myTitle"/>

    </com.github.florent37.parallax.ParallaxView>

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
``

ParallaxView
--------

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

         <!-- content -->

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

         <!-- content -->

</com.github.florent37.parallax.ScrollView>
```


TODO
--------

- Add RecyclerView Parallax

Community
--------

Looking for contributors, feel free to fork !


Credits
-------

Author: Florent Champigny

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