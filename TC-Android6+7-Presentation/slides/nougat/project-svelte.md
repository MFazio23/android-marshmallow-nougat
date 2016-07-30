## Project Svelte
### Background Optimizations

<img src="img/android-n-nlogo.jpg" height="500" />

Note:
+ Minimize RAM use by system/apps
+ Background jobs should use JobScheduler if possible
    + Apps schedule jobs while letting the system optimize based on memory/power/connectivity
    + Also can use GCMNetworkManager for legacy versions of Android
+ Restrictions
    + Apps targeting SDK 24 will not receive `CONNECTIVITY_ACTION` broadcasts
        + Even if registered in manifest
        + Apps can still listen for `CONNECTIVITY_CHANGE` via a BroadcastReceiver
    + Apps cannot send/receive `ACTION_NEW_PICTURE` or `ACTION_NEW_VIDEO` (camera) broadcasts
        + All apps on a Nougat phone, not just ones targeting SDK 24
        + Use `JobInfo` and `JobParameters` instead.
+ `CONNECTIVITY_ACTION` manes a change in network connectivity has occurred
+ Generally recommended to avoid dependencies on
    + Background services
    + Statically-registered implicit broadcast receivers