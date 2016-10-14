## Handling Permissions

<pre><code class="java slightly-smaller" data-noescape>public void onRequestPermissionsResult(int code, String permissions[], int[] results) {
    switch (code) {
        case <span class="constant">MY_PERMISSIONS_REQUEST_READ_CONTACTS</span>: {
            // If request is cancelled, the result arrays are empty.
            if (results.length > 0
                && results[0] == <span class="type-name">PackageManager</span>.<span class="constant">PERMISSION_GRANTED</span>) {
                // permission was granted
            } else {
                // permission denied
            }
            return;
        }
        //Other permissions
    }
}

</code></pre>

Note:
+ Dialog box shows the permission group, not the permission itself
    + Group: Contacts, Permission: READ_CONTACTS, WRITE_CONTACTS
+ Every permission needs to be granted explicitly, even if the user granted another permission in the same group.
    + Groupings may also change later on
