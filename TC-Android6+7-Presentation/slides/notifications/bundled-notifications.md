##Notifications
###Bundled Notifications

<img src="img/notifications-1.png" height="500" />

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
        