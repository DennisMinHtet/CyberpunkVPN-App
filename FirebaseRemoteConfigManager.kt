package com.example.vpn_app

import android.util.Log
import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class FirebaseRemoteConfigManager {

    private val TAG = "FirebaseRemoteConfigManager"
    private val firebaseRemoteConfig: FirebaseRemoteConfig = FirebaseRemoteConfig.getInstance()

    init {
        val configSettings = FirebaseRemoteConfigSettings.Builder()
            .setMinimumFetchIntervalInSeconds(3600) // Fetch every hour
            .build()
        firebaseRemoteConfig.setConfigSettingsAsync(configSettings)
        firebaseRemoteConfig.setDefaultsAsync(R.xml.remote_config_defaults)
    }

    fun fetchAndActivate(callback: (List<VpnServer>?) -> Unit) {
        firebaseRemoteConfig.fetchAndActivate()
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val updated = task.result
                    Log.d(TAG, "Config params updated: $updated")
                    val json = firebaseRemoteConfig.getString("vpn_servers")
                    val serverList = parseVpnServersJson(json)
                    callback(serverList)
                } else {
                    Log.e(TAG, "Fetch failed")
                    callback(null)
                }
            }
    }

    private fun parseVpnServersJson(json: String): List<VpnServer>? {
        return try {
            val type = object : TypeToken<List<VpnServer>>() {}.type
            Gson().fromJson(json, type)
        } catch (e: Exception) {
            Log.e(TAG, "Error parsing VPN servers JSON", e)
            null
        }
    }
}
