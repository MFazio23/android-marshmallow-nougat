##Testing Doze + App Standby

####Doze
```
$ adb shell dumpsys battery unplug
$ adb shell dumpsys deviceidle step
```

####App Standby
```
$ adb shell dumpsys battery unplug
$ adb shell am set-inactive <packageName> true
```

```
$ adb shell am set-inactive <packageName> false
$ adb shell am get-inactive <packageName>
```

Note:
+ Doze
    1. Configure device for API level 23+
    2. Connect device + Install app
    3. Run app, leave active, and shut off screen
    4. Force system to cycle through Doze modes via commands above
        + Second command may need to be run multiple times to get to an idle state.
        + Idle state can be seen after running command
    5. Observe app behavior
+ App Standby
    1. Configure device for API level 23+
    2. Connect device + Install app
    3. Run app, leave active, and shut off screen
    4. Force app into App Standby using code above (#1)
    5. Simulate waking the app with code above (#2)
    6. Observe behavior
        + Take special care that notifications and background jobs continue as expected