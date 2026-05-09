package com.example.vpn_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.vpn_app.ui.theme.VPN_AppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            VPN_AppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    VpnHomeScreen()
                }
            }
        }
    }
}

@Composable
fun VpnHomeScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF1A1A1A)) // Dark background for cyberpunk theme
    ) {
        // World Map Composable (placeholder)
        WorldMapSection()

        // Server List Composable (placeholder)
        ServerListSection()

        // Connect Button Composable (placeholder)
        ConnectButtonSection()
    }
}

@Composable
fun WorldMapSection() {
    // Placeholder for interactive neon world map
    // This will likely involve a custom Composable or an image with overlayed interactive elements
}

@Composable
fun ServerListSection() {
    // Placeholder for country/server selection list
    // This will likely be a LazyColumn with custom items
}

@Composable
fun ConnectButtonSection() {
    // Placeholder for glowing "Initiate Link" button
}

@Preview(showBackground = true)
@Composable
fun PreviewVpnHomeScreen() {
    VPN_AppTheme {
        VpnHomeScreen()
    }
}
