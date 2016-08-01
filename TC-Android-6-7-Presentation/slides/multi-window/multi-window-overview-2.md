##Multi-Window

<img src="img/mw-portrait.png" height="600" style="margin-top: -25px"/>

Note:
+ Does _not_ change the activity lifecycle
    + Active activity == most recently interacted
        + Activity is considered top-most
        + All other activities are in a paused state
            + This includes visible ones
        + Paused-but-visible has a higher priority than just paused
+ Runtime changes
    + Putting app into multi-window mode is like changing orientation
    + Dimensions are changed instead of merely swaped
    + Either handle the configuration change yourself, or system can destroy/recreate
    + Changes to `android:screenOrientation` are ignored
+ 