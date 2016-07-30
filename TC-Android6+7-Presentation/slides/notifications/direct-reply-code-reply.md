##Notifications
###Direct Reply

<pre><code class="java">private CharSequence getMessageText(Intent intent) {
Bundle remoteInput = RemoteInput.getResultsFromIntent(intent);
    if (remoteInput != null) {
        return remoteInput.getCharSequence(KEY_TEXT_REPLY);
    }
    return null;
}
</code></pre>
<pre><code class="java">// Build a new notification, which informs the user that the system
// handled their interaction with the previous notification.
Notification repliedNotification =
        new Notification.Builder(context)
                .setSmallIcon(R.drawable.ic_message)
                .setContentText(getString(R.string.replied))
                .build();

// Issue the new notification.
NotificationManager notificationManager =
        NotificationManager.from(context);
notificationManager.notify(notificationId, repliedNotification);
</code></pre>

Note:
+ Grab the message text from the intent using the same key as before
+ Create a new notification with a result
