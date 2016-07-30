##Doze

+ Unplugged + Stationary + Screen Off + Time
+ Maintenance Windows
+ Affects all apps, even if they don’t target Marshmallow
+ Able to partially whitelist apps
+ App Standby == App not being actively used by the user
    + Basically puts an app to sleep

Note:
+ Turns off network access, syncs, alarms
+ Maintenance Window is a short period of time where apps run like normal again
+ Maintenance Windows become less and less frequent over time
+ Doze is disabled by moving/turning on/connecting the device
+ Affects all apps running on Android 6.0, regardless of target API
+ Restrictions
    + Network access suspended
    + Wake locks ignored
    + AlarmManager deferred to next window (but can be manually overridden with code)
        + setAndAllowWhileIdle() and setExactAndAllowWhileIdle()
        + Cannot be fired more than once every 15 minutes
    + No Wi-Fi scans
    + Job scheduler is disabled
    + Sync adapters are disabled
+ Whitelisted apps can use the network and partial wake locks
+ Partial wake locks causes CPU to continue to run, but screen/keyboard stay off
+ Whitelisting can be manually set or apps can take users to battery optimization screen or directly to whitelist settings