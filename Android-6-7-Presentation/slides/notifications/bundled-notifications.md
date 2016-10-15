###Notifications - Bundled Notifications

<!--<img src="img/notifications-1.png" height="500" />-->

<video id="moment-video" class="feature-video" height="600" loop="loop" data-mobile-poster="https://www.android.com/static/2016/img/versions/nougat/settings-poster.jpg">
    <source class="mp4" src="https://www.android.com/static/2016/videos/nougat/ontap.mp4" type="video/mp4">
    <source class="webm" src="https://www.android.com/static/2016/videos/nougat/ontap.webm" type="video/webm">
</video>

Note:
+ Grouped messages
    + i.e. by message topic
+ In place actions
    + e.g. Dismiss, archive
+ Similar to Android Wear's Notification Stacks
+ Hierarchy
    + Top level parent notification with summary
    + One or more children
    + App should always have a group summary (even with single child)
        + System will suppress a summary with a single child
            + Not yet available; coming in later version of Nougat
        + Ensures proper experience when user swipes away children
+ When to use
    + Child notifications are complete notifications
        + Can be displayed on their own without a group summary
    + There is benefit to showing a child notification
        + Actionable (with actions specific to the child)
        + More relevant info for the user
+ Use `NotificationCompat.Builder.setGroup()'`
    + Send in string _groupKey_
        