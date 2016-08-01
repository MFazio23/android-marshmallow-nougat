## Handling Permissions

<pre><code class="java slightly-smaller" data-noescape>
// Assume thisActivity is the current activity
final int readContactPermission
    = <span class="type-name">ContextCompat</span>.checkSelfPermission(thisActivity, <span class="type-name">Manifest</span>.permission.<span class="constant">READ_CONTACTS</span>)
    
if (readContactPermission != <span class="type-name">PackageManager</span>.<span class="constant">PERMISSION_GRANTED</span>) {
    if (<span class="type-name">ActivityCompat</span>.shouldShowRequestPermissionRationale(thisActivity,
            <span class="type-name">Manifest</span>.permission.<span class="constant">READ_CONTACTS</span>)) {
    	this.showExplanation();
    } else {
        <span class="type-name">ActivityCompat</span>.requestPermissions(
        	thisActivity,
            new String[]{<span class="type-name">Manifest</span>.permission.<span class="constant">READ_CONTACTS</span>},
            <span class="constant">MY_PERMISSIONS_REQUEST_READ_CONTACTS</span>
        );
    }
}
</code></pre>

Note:
+ The code checks for the read contacts permission
    + If it's not granted, it checks whether or not it was previously denied
        + If so, you can display an explanation
        + If not, you display the request window.
+ Request window for permissions is system-set, cannot be changed.
    + You _can_ create a window to explain before, though.
