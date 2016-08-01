<img src="img/gcm-cycle.svg" width="95%" />

Note:
+ All apps needing real-time connectivity can use GCM
+ Shared connection == optimized battery usage
+ High-priority GCM messages allow waking from idle, but then return to Doze state.
    + Does not otherwise affect Doze mode