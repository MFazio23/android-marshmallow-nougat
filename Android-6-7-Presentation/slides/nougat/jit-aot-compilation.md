##JIT + AOT Compilation

+ JIT Compiler with Code Profiling
+ Profile-Guided Compilation for JIT/AOT
+ Quick Path to App Install

Note:
+ JIT compiler with code profiling to ART (Android Run Time)
    + Improves app performance as they run
    + Compliments ART's current AOT (Ahead of Time) compiler
        + Improve runtime performance
        + Save storage space
        + Speed up app/system updates
+ Profile-guided compilation allows ART to manage JIT/AOT compilation
    + Maintains a profile of an app's "hot" methods
        + Pre-compiles/caches these methods for performance improvements
        + Other app pieces are left un-compiled until used.
    + Helps reduce app's overall RAM footprint
+ Pre-compilation is only done when device is idle and charging
+ Quick Path to App Install
    + Large apps install much, MUCH faster
    + System updates are faster due to no optimizing step
+ Give example of BCycle app
    + AOT vs. JIT
    + Splitting APK into different CPUs