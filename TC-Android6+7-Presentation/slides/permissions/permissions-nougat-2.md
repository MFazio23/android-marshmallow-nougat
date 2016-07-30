## Nougat Permission Changes

<img src="img/scoped-folder-access-dont-ask.png" style="margin-top: -50px" />

Note:
+ Scoped Directory Access, cont.
    + When requesting directory access, `onActivityResult()` is called
        + Success == `Activity.RESULT_OK`
        + Denied == `Activity.RESULT_CANCELED`
    + Persist the directory URI so you don't bug the user
    + Do not quickly request access again if denied
    + If DENY + "Don't Ask Again" is selected, result will always be `Activity.RESULT_CANCELED`
+ File System Permissions
