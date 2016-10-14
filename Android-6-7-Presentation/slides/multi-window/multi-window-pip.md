##Android TV PIP

<img src="img/android-tv-pip-drawing.png" height="500" />

Note:
+ Android TV only
+ Enter with `Activity.enterPictureInPictureMode()`
+ Android Manifest settings
    + `android:supportsPictureInPicture="true"`
        + Setting is ignored if `android:resizeableActivity="true"` is _"false"_
    + `android:resizeableActivity="true"`