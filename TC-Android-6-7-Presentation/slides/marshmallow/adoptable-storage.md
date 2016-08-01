## Adoptable Storage

<img src="img/adoptable-storage.png" height="500" />

Note:
+ Developed for Android One (emerging markets)
+ Previously, moving to the SD was manual
	+ Some apps could be moved over
	+ Some apps supported storing data on the SD card
+ External storage (SD card) can be recognized as internal storage
+ Device is encrypted and formatted same as internal storage
+ Storage speed is quickly tested to see how well it'll work
+ Dynamically referenced paths (getFilesDir(), getCacheDir(), etc) will work with SD card "internal" storage
+ A number of phone makers have started to disable this due to the speed differences with SD cards and internal storage
    + Galaxy S7 (Edge), LG G5

