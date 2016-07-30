##App Linking

```
<intent-filter android:autoVerify="true">
	<action android:name="android.intent.action.VIEW"/>
	<category android:name="android.intent.category.DEFAULT"/>
	<category android:name="android.intent.category.BROWSABLE"/>
	<data android:host="applinkingexperiment.appspot.com" android:scheme="http"/>
	<data android:host="applinkingexperiment.appspot.com" android:scheme="https"/>
</intent-filter>
```

Note:
+ Default handler for URI only if all URIs are found.
+ Verification happens on install