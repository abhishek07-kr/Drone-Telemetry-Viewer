package com.example.dronetelemetryviewerproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import ui.TelemetryScreen
import viewmodel.TelemetryViewModel

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            val telemetryViewModel: TelemetryViewModel =
                viewModel()

            val telemetry =
                telemetryViewModel.telemetry.collectAsState()

            TelemetryScreen(
                telemetry = telemetry.value,
                viewModel = telemetryViewModel
            )
        }
    }
}