package org.faziodev.android67samples.receivers;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.RemoteInput;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import org.faziodev.android67samples.R;
import org.faziodev.android67samples.fragments.nougat.NotificationsFragment;

/**
 * Created by Michael on 2016-08-06.
 */
public class ToastReceiver extends BroadcastReceiver {

    public static final String GENERIC_TOAST_RECEIVER = "org.faziodev.intents.GENERIC_TOAST_RECEIVER";
    public static final String DIRECT_REPLY_INTENT = "org.faziodev.intents.DIRECT_REPLY_INTENT";

    @Override
    public void onReceive(Context context, Intent intent) {
        String text = "";

        if (intent.getAction().equals(DIRECT_REPLY_INTENT)) {
            final int notificationId = intent.getIntExtra("NotificationId", 0);
            final Bundle remoteInput = RemoteInput.getResultsFromIntent(intent);

            if(remoteInput != null) {
                text = "Entered text: " + remoteInput.getCharSequence(NotificationsFragment.DIRECT_REPLY_KEY);
            }

            Notification replyNotif = new Notification.Builder(context)
                .setSmallIcon(R.drawable.ic_comment_black_24px)
                .setContentText("Replied!")
                .build();

            context.getSystemService(NotificationManager.class).notify(notificationId, replyNotif);

        } else {
            text = intent.getStringExtra("ToastText");
        }

        Toast.makeText(context, text, Toast.LENGTH_LONG).show();
    }
}
