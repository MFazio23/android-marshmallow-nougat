##Development Notes

+ Apache HTTP Client support is removed
+ Programmatic access to local hardware IDs removed
+ OpenSSL -> BoringSSL
+ Floating toolbar for text selection available

Note:
+ Marshmallow removes programmatic access to the device’s local hardware identifier for apps using the Wi-Fi and Bluetooth APIs
+ BoringSSL is only relevant for NDK
+ Fork of OpenSSL
+ Text selection toolbar requires a few code changes, found on the full list page.