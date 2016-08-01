##Data Saver

<img src="img/nougat-data-saver-apps.png" height="500" />

Note:
+ Only active when Data Saver is turned on in settings + device is on a metered network
+ System blocks background data usage
+ Apps can be whitelisted
    + As shown
+ `getRestrictBackgroundStatus()`
    + `RESTRICT_BACKGROUND_STATUS_DISABLED` == Data saver is disabled
    + `RESTRICT_BACKGROUND_STATUS_ENABLED` == Enabled for app
        + App should try to limit data usage in foreground
        + App should gracefully handle background data usage restrictions
    + `RESTRICT_BACKGROUND_STATUS_WHITELISTED`