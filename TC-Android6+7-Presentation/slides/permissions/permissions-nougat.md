## Nougat Permission Changes

<img src="img/scoped-folder-access-framed.png" style="margin-top: -50px" />

Note:
+ Scoped Directory Access
    + MM external storage access == All || Nothing
        + READ_EXTERNAL_STORAGE
        + WRITE_EXTERNAL_STORAGE
    + StorageManager can give StorageVolume instance
    + StorageManager can give containing StorageVolume from file
    + When creating an intent on the volume, send in the directory you want
        + e.g. Environment.DIRECTORY_PICTURES, Environment.DIRECTORY_DOWNLOADS
+ File System Permissions
