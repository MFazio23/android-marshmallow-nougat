##Notifications
###Direct Reply

<pre><code class="java">// Key for the string that's delivered in the action's intent.
private static final String KEY_TEXT_REPLY = "key_text_reply";
String replyLabel = getResources().getString(R.string.reply_label);
RemoteInput remoteInput = new RemoteInput.Builder(KEY_TEXT_REPLY)
    .setLabel(replyLabel)
    .build();
</code></pre>
<pre><code class="java">// Create the reply action and add the remote input.
Notification.Action action =
    new Notification.Action.Builder(
            R.drawable.ic_reply_icon, getString(R.string.label), replyPendingIntent)
        .addRemoteInput(remoteInput)
        .build();
</code></pre>
<pre><code class="java">// Build the notification and add the action.
Notification newMessageNotification = new Notification.Builder(mContext)
    .setContentTitle(getString(R.string.title))
    .setContentText(getString(R.string.content))
    .addAction(action))
    .build();
</code></pre>
Note:
+ Block 1
    + Create remote input with label value and key
+ Block 2
    + Create action with icon, label, and intent to call when notification is pressed
    + Add remote input created in block 1
+ Block 3
    + Create new notification
        + Action is added from Block 2
