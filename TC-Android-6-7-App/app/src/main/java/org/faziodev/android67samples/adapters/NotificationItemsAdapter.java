package org.faziodev.android67samples.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.faziodev.android67samples.R;
import org.faziodev.android67samples.types.NotificationListItem;

import java.util.List;

/**
 * Created by Michael on 2016-08-06.
 */
public class NotificationItemsAdapter extends BaseAdapter {

    private final List<NotificationListItem> items;
    private final LayoutInflater inflater;

    public NotificationItemsAdapter(final Context context, final List<NotificationListItem> items) {
        this.items = items;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return this.items == null ? 0 : this.items.size();
    }

    @Override
    public Object getItem(int i) {
        return this.items.get(i);
    }

    @Override
    public long getItemId(int i) {
        return this.getItem(i).hashCode();
    }

    @Override
    public View getView(final int i, final View view, final ViewGroup viewGroup) {
        final View returnView = view != null ? view : this.inflater.inflate(R.layout.notification_list_item, null);

        final TextView header = (TextView) returnView.findViewById(R.id.notification_list_item_header);
        final TextView description = (TextView) returnView.findViewById(R.id.notification_list_item_description);

        final NotificationListItem item = (NotificationListItem) this.getItem(i);

        header.setText(item.getHeader());
        description.setText(item.getDescription());

        return returnView;
    }
}
