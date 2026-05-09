# CyberVPN Android Application

This project provides a foundational Android VPN application with a Cyberpunk aesthetic, built with Kotlin and Jetpack Compose. It integrates WireGuard for VPN functionality, Firebase Remote Config for dynamic server updates, and OneSignal for push notifications.

## Project Structure

```
vpn_app/
├── app/
│   ├── src/
│   │   ├── main/
│   │   │   ├── AndroidManifest.xml
│   │   │   ├── java/com/example/vpn_app/
│   │   │   │   ├── MainActivity.kt
│   │   │   │   ├── VpnApplication.kt
│   │   │   │   ├── WireGuardVpnService.kt
│   │   │   │   ├── FirebaseRemoteConfigManager.kt
│   │   │   │   ├── VpnManager.kt
│   │   │   │   ├── WorldMapSection.kt
│   │   │   │   ├── ServerListSection.kt
│   │   │   │   ├── ConnectButtonSection.kt
│   │   │   │   └── VpnServer.kt (data class for server model)
│   │   │   ├── res/
│   │   │   │   ├── drawable/
│   │   │   │   │   └── ic_launcher_background.xml
│   │   │   │   ├── layout/
│   │   │   │   │   └── activity_main.xml
│   │   │   │   ├── values/
│   │   │   │   │   ├── colors.xml
│   │   │   │   │   ├── strings.xml
│   │   │   │   │   └── themes.xml
│   │   │   │   └── xml/
│   │   │   │       ├── data_extraction_rules.xml
│   │   │   │       ├── backup_rules.xml
│   │   │   │       └── remote_config_defaults.xml
│   │   │   └── google-services.json (PLACE YOUR FIREBASE CONFIG FILE HERE)
│   │   └── AndroidManifest.xml
│   ├── build.gradle
│   └── proguard-rules.pro
├── build.gradle
└── settings.gradle
```

## Setup Instructions

### 1. Firebase Integration

To integrate Firebase into your project:

1.  **Obtain `google-services.json`:** Follow the instructions on the [Firebase documentation](https://firebase.google.com/docs/android/setup) to add a new Android app to your Firebase project. Download the `google-services.json` file.
2.  **Place the file:** Copy the downloaded `google-services.json` file into the `vpn_app/app/` directory. This file contains your Firebase project configuration.

### 2. OneSignal Integration

To enable push notifications with OneSignal:

1.  **Get your OneSignal App ID:** Create an app on the [OneSignal dashboard](https://onesignal.com/) and obtain your unique App ID.
2.  **Update `VpnApplication.kt`:** Open `vpn_app/app/src/main/java/com/example/vpn_app/VpnApplication.kt` and replace `
