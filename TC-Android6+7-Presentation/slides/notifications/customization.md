## Notifications
### Customization

```
Notification notification = new Notification.Builder()
	.setStyle(new Notification.MessagingStyle("Me")
	.setConversationTitle("Team lunch")
	.addMessage("Hi", timestamp1, null) // Pass in null for user.
	.addMessage("What's up?", timestamp2, "Coworker")
	.addMessage("Not much", timestamp3, null)
	.addMessage("How about lunch?", timestamp4, "Coworker"))
	.build();
```

Note:
+ Custom Views
    + Customize notification views while keeping system decorations
        + Notification headers, actions, expandable layouts
    + `DecoratedCustomViewStyle()` and `DecoratedMediaCustomViewStyle()`
    + Call the `setStyle()` method
+ Message Style Customizations
    + `MessagingStyle` class
    + Change sever notification labels
        + Message
        + Conversation Title
        + Content View