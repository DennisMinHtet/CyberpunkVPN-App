package com.example.vpn_app

import android.content.Intent
import android.net.VpnService
import android.os.ParcelFileDescriptor
import android.util.Log
import com.wireguard.android.backend.Backend
import com.wireguard.android.backend.GoBackend
import com.wireguard.config.Config
import com.wireguard.config.Interface
import com.wireguard.config.Peer
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import java.io.IOException

class WireGuardVpnService : VpnService(), CoroutineScope {

    private val TAG = "WireGuardVpnService"
    private var vpnThread: Job? = null
    private var parcelFileDescriptor: ParcelFileDescriptor? = null

    override val coroutineContext = Dispatchers.IO + Job()

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.d(TAG, "onStartCommand")
        if (intent?.action == "START_VPN") {
            startVpn()
        } else if (intent?.action == "STOP_VPN") {
            stopVpn()
        }
        return START_NOT_STICKY
    }

    private fun startVpn() {
        Log.d(TAG, "Starting VPN")
        vpnThread = launch {
            try {
                // Placeholder for WireGuard configuration
                // In a real app, this would come from Firebase Remote Config or a local store
                val privateKey = "YOUR_PRIVATE_KEY"
                val publicKey = "YOUR_PUBLIC_KEY"
                val endpoint = "YOUR_ENDPOINT_IP:PORT"
                val allowedIPs = "0.0.0.0/0, ::/0"
                val dnsServers = "8.8.8.8, 8.8.4.4"

                val wgInterface = Interface.Builder()
                    .setPrivateKey(privateKey)
                    .addAddresses("10.0.0.2/24") // Example VPN client IP
                    .addDnsServers(dnsServers.split(", ").toTypedArray())
                    .build()

                val wgPeer = Peer.Builder()
                    .setPublicKey(publicKey)
                    .addAllowedIps(allowedIPs.split(", ").toTypedArray())
                    .setEndpoint(endpoint)
                    .build()

                val config = Config.Builder()
                    .setInterface(wgInterface)
                    .addPeer(wgPeer)
                    .build()

                val backend = GoBackend(this@WireGuardVpnService)
                parcelFileDescriptor = backend.tunnel(config)

                if (parcelFileDescriptor != null) {
                    val builder = Builder()
                        .setSession("CyberVPN")
                        .addAddress("10.0.0.1", 24) // Example VPN server IP
                        .addRoute("0.0.0.0", 0)
                        .addDnsServer("8.8.8.8")

                    parcelFileDescriptor = builder.establish()
                    Log.d(TAG, "VPN Established")
                } else {
                    Log.e(TAG, "Failed to establish VPN: parcelFileDescriptor is null")
                }

            } catch (e: Exception) {
                Log.e(TAG, "Error starting VPN", e)
                stopVpn()
            }
        }
    }

    private fun stopVpn() {
        Log.d(TAG, "Stopping VPN")
        vpnThread?.cancel()
        try {
            parcelFileDescriptor?.close()
            parcelFileDescriptor = null
            Log.d(TAG, "VPN Stopped")
        } catch (e: IOException) {
            Log.e(TAG, "Error closing VPN tunnel", e)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy")
        stopVpn()
    }
}
