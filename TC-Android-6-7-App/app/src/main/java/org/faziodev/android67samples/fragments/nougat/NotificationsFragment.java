package org.faziodev.android67samples.fragments.nougat;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v4.app.RemoteInput;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import org.faziodev.android67samples.MainActivity;
import org.faziodev.android67samples.R;
import org.faziodev.android67samples.adapters.NotificationItemsAdapter;
import org.faziodev.android67samples.types.NotificationListItem;

import java.util.ArrayList;
import java.util.List;

public class NotificationsFragment extends Fragment {

    public static final String DIRECT_REPLY_KEY = "direct_reply_key";

    private NotificationManagerCompat notificationManager = null;
    private List<String> groupedNotifications = new ArrayList<>();

    public NotificationsFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.fragment_notifications, container, false);

        final ListView listView = (ListView) view.findViewById(R.id.notification_types_list_view);

        final List<NotificationListItem> items = this.getNotificationListItems();

        listView.setAdapter(new NotificationItemsAdapter(this.getContext(), items));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                handleItemClicked((NotificationListItem) adapterView.getItemAtPosition(i));
            }
        });

        return view;
    }

    private List<NotificationListItem> getNotificationListItems() {
        final List<NotificationListItem> list = new ArrayList<>();

        list.add(new NotificationListItem("Basic Notification", "This will send a basic notification to the system.", R.drawable.ic_chat_bubble_black_24px));
        list.add(new NotificationListItem("Grouped Notification", "This will send a notification to the system that will be added to a group.", R.drawable.ic_announcement_black_24px, "group_notif", false));
        list.add(new NotificationListItem("Direct Reply Notification", "This will send a notification to the system that will be added to a group.", R.drawable.ic_chat_black_24px));

        return list;
    }

    private void handleItemClicked(final NotificationListItem item) {
        if (this.notificationManager == null) {
            this.notificationManager = NotificationManagerCompat.from(this.getActivity());
        }
        final NotificationCompat.Builder notificationBuilder = this.createNotificationBuilder(this.getContext(), item);

        this.notificationManager.notify(item.getNotificationId(), notificationBuilder.build());
    }

    private NotificationCompat.Builder createNotificationBuilder(final Context context, final NotificationListItem item) {

        final Intent intent = new Intent(context, MainActivity.class);
        intent.putExtra("Extra-NotificationId", item.getNotificationId());
        final PendingIntent pendingIntent = PendingIntent.getActivity(this.getActivity(), 0, intent, 0);

        final NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(context)
            .setDefaults(Notification.DEFAULT_ALL)
            .setSmallIcon(item.getIconId())
            .setContentTitle(item.getHeader())
            .setContentText(item.getDescription())
            .setContentIntent(pendingIntent)
            .setAutoCancel(true);

        if (item.isGrouped()) {
            this.addSummaryNotification(item.getGroupName());
            notificationBuilder.setGroup(item.getGroupName());
        }

        if(item.isDirectReply()) {
            final NotificationCompat.Action directReplyAction = this.getDirectReplyAction();
            notificationBuilder.addAction(directReplyAction);
        }

        return notificationBuilder;
    }

    private void addSummaryNotification(String groupName) {
        //TODO: This isn't a great way to handle notification grouping as it doesn't know if notifications have been canceled.
        //      It's more just to illustrate that you need a summary, but not a lot of them.
        if (!this.groupedNotifications.contains(groupName)) {
            final NotificationCompat.Builder builder = new NotificationCompat.Builder(this.getContext())
                .setSmallIcon(R.drawable.ic_question_answer_black_24px)
                .setContentTitle(groupName)
                .setGroup(groupName)
                .setGroupSummary(true);

            this.notificationManager.notify((int) System.currentTimeMillis(), builder.build());
            this.groupedNotifications.add(groupName);
        }
    }

    private NotificationCompat.Action getDirectReplyAction() {
        final RemoteInput remoteInput = new RemoteInput.Builder(DIRECT_REPLY_KEY)
            .setLabel("Direct Reply")
            .build();

        final Intent intent = new Intent(this.getContext(), MainActivity.class);
        final PendingIntent pendingIntent = PendingIntent.getActivity(this.getActivity(), 0, intent, 0);

        return new NotificationCompat.Action.Builder(R.drawable.ic_menu_send, "Replying...", pendingIntent)
            .addRemoteInput(remoteInput)
            .build();
    }
}
