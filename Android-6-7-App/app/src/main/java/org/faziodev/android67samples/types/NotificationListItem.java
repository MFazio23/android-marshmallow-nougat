package org.faziodev.android67samples.types;

/**
 * Created by Michael on 2016-08-06.
 */
public class NotificationListItem {

    private final String header;
    private final String description;
    private final String groupName;
    private final int iconId;
    private final boolean directReply;

    public NotificationListItem(String header, String description, int iconId, String groupName, boolean directReply) {
        this.description = description;
        this.header = header;
        this.iconId = iconId;
        this.groupName = groupName;
        this.directReply = directReply;
    }

    public NotificationListItem(String header, String description, int iconId) {
        this(header, description, iconId, "", false);
    }

    public NotificationListItem(String header, String description, int iconId, boolean directReply) {
        this(header, description, iconId, "", directReply);
    }

    public String getDescription() {
        return description;
    }

    public boolean isGrouped() {
        return this.groupName != null && !this.groupName.equals("");
    }

    public String getGroupName() {
        return groupName;
    }

    public String getHeader() {
        return header;
    }

    public int getNotificationId() {
        return (int) System.currentTimeMillis();
    }

    @Override
    public String toString() {
        return "NotificationListItem{" +
            "description='" + description + '\'' +
            ", header='" + header + '\'' +
            ", groupName='" + groupName + '\'' +
            ", iconId=" + iconId +
            ", directReply=" + directReply +
            '}';
    }

    public boolean isDirectReply() {
        return this.directReply;
    }

    public int getIconId() {
        return iconId;
    }
}
