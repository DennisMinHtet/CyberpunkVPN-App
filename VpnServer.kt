package com.example.vpn_app

data class VpnServer(
    val id: String,
    val country: String,
    val city: String,
    val ping: Int,
    val load: Int,
    val wireguardConfig: String // WireGuard configuration for this server
)
