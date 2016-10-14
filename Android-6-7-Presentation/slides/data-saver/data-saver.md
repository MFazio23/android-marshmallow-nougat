##Data Saver

<!--<img src="img/nougat-data-saver-apps.png" height="500" />-->

<video id="choose-video" class="feature-video" height="600" loop="loop" data-mobile-poster="https://www.android.com/static/2016/img/versions/nougat/datasaver-poster.jpg">
    <source class="mp4" src="https://www.android.com/static/2016/videos/nougat/datasaver.mp4" type="video/mp4">
    <source class="webm" src="https://www.android.com/static/2016/videos/nougat/datasaver.webm" type="video/webm">
</video>

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