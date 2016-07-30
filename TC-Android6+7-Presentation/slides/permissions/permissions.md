## Permissions

<img src="img/app-permissions-allow-01.png" height="500" />

Note:
+ Permissions can either be shown at run-time or on-demand (via pop-up)
 	+ Apps targeting v23 will not ask for permissions acceptance right away
 	+ Critical permissions at run-time (as soon as the app's started)
 	+ "Extra" permissions on-demand
+ Allow is permanent, deny is one-time
 	+ Pop-up shows a "Never Ask Again" checkbox
 	+ Can still turn off via settings menu
+ Denied permissions shouldn't crash apps
    + App is informed so it can react