## Auto-Backup

<img src="img/auto-backup.png" height="500" />

Note:
+ Backs up everything in /data/data/[app-name]
+ Devs and users can completely opt-out
+ Automatically available if device is idle, charging, on WiFi, and >24 hours since last backup
+ Stored encrypted on user's Google Drive, does not count against user's drive quota
+ No additional code needed
+ Defaults to backing up almost all data an app creates, excluding automatically excluded data files
+ Backup XML can be created
	+ Include/Exclude files/domains (file, database, sharedpref, external, root) explicitly
	+ Specifying an include element will cause the system to only include those items
	+ Excludes take precedence
+ Can globally disable via android:allowBackup="false"
+ Lower versions of Android can either
	+ Implement the Backup API - https://developer.android.com/training/backup/backupapi.html
	+ Use existing backup mechanism via BackupAgent


