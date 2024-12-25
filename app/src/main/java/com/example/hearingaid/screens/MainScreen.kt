package com.example.hearingaid.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material3.Button
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.hearingaid.viewmodel.MainViewModel

@Preview
@Composable
fun MainScreen(viewModel: MainViewModel = viewModel()) {
    // Main layout
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF8F8F8)) // Off-white background
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            // Sliders for Volume and Boost
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // Volume Slider
                Text(
                    text = "Volume: ${(viewModel.volumeLevel * 100).toInt()}%",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
                Slider(
                    value = viewModel.volumeLevel,
                    onValueChange = { viewModel.updateVolume(it) },
                    valueRange = 0f..1f,
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Boost Slider
                Text(
                    text = "Boost: ${(viewModel.boostLevel * 100).toInt()}%",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
                Slider(
                    value = viewModel.boostLevel,
                    onValueChange = { viewModel.updateBoost(it) },
                    valueRange = 0f..1f,
                    modifier = Modifier.fillMaxWidth()
                )
            }

            // Start/Stop Button
            Button(
                onClick = { viewModel.toggleAudioProcessing() },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .align(Alignment.CenterHorizontally)
            ) {
                Text(
                    text = if (viewModel.isProcessing) "Stop" else "Start",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}
