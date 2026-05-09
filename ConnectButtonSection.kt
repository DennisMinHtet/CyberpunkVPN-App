package com.example.vpn_app

import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.vpn_app.ui.theme.ElectricPurple
import com.example.vpn_app.ui.theme.MatrixGreen
import com.example.vpn_app.ui.theme.NeonCyan

@Composable
fun ConnectButtonSection() {
    var isConnected by remember { mutableStateOf(false) }

    val gradientColors = listOf(NeonCyan, ElectricPurple, MatrixGreen)

    val infiniteTransition = rememberInfiniteTransition(label = "glowTransition")
    val glowAlpha by infiniteTransition.animateFloat(
        initialValue = 0.3f,
        targetValue = 0.7f,
        animationSpec = infiniteRepeatable(
            animation = tween(1000, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "glowAlpha"
    )

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .size(150.dp)
                .clip(CircleShape)
                .background(Brush.radialGradient(gradientColors))
                .shadow(elevation = 10.dp, ambientColor = NeonCyan.copy(alpha = glowAlpha), spotColor = ElectricPurple.copy(alpha = glowAlpha), shape = CircleShape)
                .clickable {
                    isConnected = !isConnected
                    // Handle VPN connection/disconnection logic here
                },
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = if (isConnected) "Connected" else "Initiate Link",
                color = Color.White,
                fontSize = 22.sp
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewConnectButtonSection() {
    ConnectButtonSection()
}
