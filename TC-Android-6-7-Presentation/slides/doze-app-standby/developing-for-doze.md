##Developing for Doze

<pre><code class="java" data-noescape>
final <span class="type-name">AlarmManager</span> alarmManager = <span class="type-name">Context</span>.getSystemService(<span class="type-name">Context</span>.<span class="constant">ALARM_SERVICE</span>);

final <span class="type-name">Intent</span> intent = new <span class="type-name">Intent</span>(ctx, <span class="type-name">AlarmReceiver</span>.class);

final <span class="type-name">PendingIntent</span> operationToExecute = <span class="type-name">PendingIntent</span>.getActivity(ctx, 0, intent, 0);

alarmManager.setAndAllowWhileIdle(type, triggerAtMillis, pendingIntent);

alarmManager.setExactAndAllowWhileIdle(type, triggerAtMillis, pendingIntent);
</code></pre>

Note:
+ Alarm Manager is used when something should execute at a certain time even when the app isn't running
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