##Data Saver

```
ConnectivityManager connMgr 
    = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);

if (connMgr.isActiveNetworkMetered()) {
  // Checks user’s Data Saver settings.
  switch (connMgr.getRestrictBackgroundStatus()) {
    case RESTRICT_BACKGROUND_STATUS_ENABLED: //No background data; restrict otherwise
    case RESTRICT_BACKGROUND_STATUS_WHITELISTED: //Use less data when possible
    case RESTRICT_BACKGROUND_STATUS_DISABLED: //Use less data when possible
  }
} else {
  // The device is not on a metered network.
  // Use data as required to perform syncs, downloads, and updates.
}
```

Note:
+ `ConnectivityManager.getRestrictBackgroundStatus()`
    + `RESTRICT_BACKGROUND_STATUS_DISABLED` == Data saver is disabled
    + `RESTRICT_BACKGROUND_STATUS_ENABLED` == Enabled for app
        + App should try to limit data usage in foreground
        + App should gracefully handle background data usage restrictions
    + `RESTRICT_BACKGROUND_STATUS_WHITELISTED`        
        + App should try to limit data usage in foreground and background