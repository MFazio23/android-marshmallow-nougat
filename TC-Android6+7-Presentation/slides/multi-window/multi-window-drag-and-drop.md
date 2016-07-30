## Multi-Window
###Drag and Drop

```
View.startDragAndDrop()
View.cancelDragAndDrop()
View.updateDragShadow()
```
Note:
+ Drag and drop data inside a single activity or between two sharing the screen
+ `View.startDragAndDrop()` is an alias for `View.startDrag()`
    + Send in `View.DRAG_FLAG_GLOBAL` as parameter to enable cross-activity DnD
    + Send in `View.DRAG_FLAG_GLOBAL_URI_READ|WRITE` as parameter to allow URI permissions
+ `View.cancelDragAndDrop()` and `View.updateDragShadow()` can only be called by originating app