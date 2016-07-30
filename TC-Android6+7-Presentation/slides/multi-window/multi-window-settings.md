## Multi-Window
###Settings

```
//Android Manifest settings
android:resizeableActivity=["true" | "false"]
android:supportsPictureInPicture=["true" | "false"]

//Layout attributes
android:minWidth
android:minHeight
android:defaultWidth
android:defaultHeight
android:gravity
```

```
//Methods on Activity class
isInMultiWindowMode();
isInPictureInPictureMode();
onMultiWindowModeChanged();
onPictureInPictureModeChanged();
enterPictureInPictureMode();
```
Note:
+ `android:resizeableActivity` allows split-screen and freeform modes
    + If _false_, attempting to launch in multi-window mode will cause app to be full screen.
    + Defaults to _true_
+ `android:supportsPictureInPicture` is ignored if `android:resizeableActivity` is false.
+ Layout attributes
    + Only minHeight, minWidth are valid for split-screen
    + All apply for freeform mode
+ `Intent.FLAG_ACTIVITY_LAUNCH_TO_ADJACENT`
    + Launches a new activity in multi-window mode (next to current activity)
    + Split-screen: Attempts to put new Activity next to launching one (if possible)
    + Not split-screen: No effect
    + `ActivityOptions.setLaunchBounds()` can be used for freeform mode.
+ Multi-orientation app targeting SDK < 24
    + System forcibly resizes the app
    + Displays a warning dialog that app my behave unexpectedly
+ Fixed-orientation app targeting SDK < 24 will just take over the whole screen