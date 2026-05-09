package com.example.vpn_app

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.vpn_app.ui.theme.NeonCyan
import com.example.vpn_app.ui.theme.ElectricPurple
import com.example.vpn_app.ui.theme.MatrixGreen

@Composable
fun WorldMapSection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(250.dp) // Adjust height as needed
    ) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            // Placeholder for a simplified world map drawing
            // In a real application, this would involve complex path drawing or a custom image asset

            // Draw a glowing rectangle as a placeholder for a continent
            drawRect(
                color = NeonCyan,
                topLeft = Offset(size.width * 0.1f, size.height * 0.2f),
                size = androidx.compose.ui.geometry.Size(size.width * 0.3f, size.height * 0.4f),
                style = Stroke(width = 5.dp.toPx())
            )
            drawRect(
                color = ElectricPurple,
                topLeft = Offset(size.width * 0.6f, size.height * 0.3f),
                size = androidx.compose.ui.geometry.Size(size.width * 0.25f, size.height * 0.3f),
                style = Stroke(width = 5.dp.toPx())
            )
            drawRect(
                color = MatrixGreen,
                topLeft = Offset(size.width * 0.35f, size.height * 0.6f),
                size = androidx.compose.ui.geometry.Size(size.width * 0.4f, size.height * 0.2f),
                style = Stroke(width = 5.dp.toPx())
            )

            // Draw some connecting lines for a network effect
            drawLine(
                color = NeonCyan,
                start = Offset(size.width * 0.25f, size.height * 0.4f),
                end = Offset(size.width * 0.7f, size.height * 0.45f),
                strokeWidth = 3.dp.toPx()
            )
            drawLine(
                color = ElectricPurple,
                start = Offset(size.width * 0.7f, size.height * 0.45f),
                end = Offset(size.width * 0.55f, size.height * 0.7f),
                strokeWidth = 3.dp.toPx()
            )
            drawLine(
                color = MatrixGreen,
                start = Offset(size.width * 0.55f, size.height * 0.7f),
                end = Offset(size.width * 0.25f, size.height * 0.4f),
                strokeWidth = 3.dp.toPx()
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewWorldMapSection() {
    WorldMapSection()
}
