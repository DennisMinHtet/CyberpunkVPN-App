package com.example.vpn_app

import android.app.Application
import com.google.firebase.FirebaseApp
import com.onesignal.OneSignal
import com.onesignal.debug.LogLevel

class VpnApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        // Initialize Firebase
        FirebaseApp.initializeApp(this)

        // OneSignal Initialization
        OneSignal.Debug.LogLevel = LogLevel.VERBOSE
        // <<< PASTE YOUR ONESIGNAL APP ID HERE >>>
        OneSignal.initWithContext(this, "381ad7ff-e44c-485b-a376-d6309aac4231")
        OneSignal.setAppId("381ad7ff-e44c-485b-a376-d6309aac4231")
    }
}
