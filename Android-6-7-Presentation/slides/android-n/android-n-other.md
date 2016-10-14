##Android N

+ Data Saver
+ Direct Boot
+ Scoped Directory Access
+ TV Recording
+ More Background Optimizations

Note:
+ Data Saver
    + Enabled device-wide
    + Blocks background data
    + Signals foreground apps to use less data when possible
    + ConnectivityManager finds which data usage restrictions are being applied
    + Able to whitelist apps
        + Not sure if this is by user or app dev
+ Direct Boot
    + Device is powered, but user has not unlocked device
    + Apps do not run during Direct Boot by default
    + Can register apps to run in this mode
        + Scheduled notifications
        + Important user notifications
        + Accessibility services
+ Scoped Directory Access
    + Targeted directory access for permissions
    + e.g. Specific pictures directory vs. all external folders
+ TV Recording
    + Pause and resume channel playback
    + Allow for multiple recorded sessions