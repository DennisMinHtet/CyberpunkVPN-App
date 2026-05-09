package com.example.vpn_app

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.vpn_app.ui.theme.ElectricPurple
import com.example.vpn_app.ui.theme.LightGray
import com.example.vpn_app.ui.theme.MatrixGreen
import com.example.vpn_app.ui.theme.NeonCyan

data class VpnServer(
    val id: String,
    val country: String,
    val city: String,
    val ping: Int,
    val load: Int
)

@Composable
fun ServerListSection() {
    val servers = listOf(
        VpnServer("1", "USA", "New York", 20, 30),
        VpnServer("2", "Germany", "Frankfurt", 50, 60),
        VpnServer("3", "Japan", "Tokyo", 120, 45),
        VpnServer("4", "Australia", "Sydney", 180, 70),
        VpnServer("5", "Brazil", "Sao Paulo", 90, 20)
    )

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(
            text = "Select Server",
            color = NeonCyan,
            fontSize = 20.sp,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        LazyColumn {
            items(servers) {
                ServerItem(server = it) {
                    // Handle server selection
                }
            }
        }
    }
}

@Composable
fun ServerItem(server: VpnServer, onServerSelected: (VpnServer) -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
            .clickable { onServerSelected(server) },
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF2C2C2C)) // Darker card background
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text(text = "${server.city}, ${server.country}", color = NeonCyan, fontSize = 16.sp)
                Spacer(modifier = Modifier.height(4.dp))
                Text(text = "Ping: ${server.ping}ms", color = LightGray, fontSize = 12.sp)
            }
            Text(text = "Load: ${server.load}%", color = MatrixGreen, fontSize = 14.sp)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewServerListSection() {
    ServerListSection()
}
