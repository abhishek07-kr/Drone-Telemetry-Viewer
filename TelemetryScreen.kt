package ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import data.TelemetryData
import viewmodel.TelemetryViewModel

@Composable
fun TelemetryScreen(
    telemetry: TelemetryData,
    viewModel: TelemetryViewModel
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {

        Text(
            text = "Drone Telemetry Viewer",
            style = MaterialTheme.typography.headlineSmall
        )

        Text("Latitude : ${telemetry.latitude}")
        Text("Longitude : ${telemetry.longitude}")
        Text("Altitude : ${telemetry.altitude}")
        Text("Battery : ${telemetry.battery}%")
        Text("Flight Mode : ${telemetry.flightMode}")
        Text("Armed : ${telemetry.armed}")
        Text("Connected : ${telemetry.connected}")

        Spacer(modifier = Modifier.height(10.dp))

        Button(
            onClick = { viewModel.connect() }
        ) {
            Text("Connect")
        }

        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Button(onClick = { viewModel.arm() }) {
                Text("Arm")
            }

            Button(onClick = { viewModel.disarm() }) {
                Text("Disarm")
            }
        }

        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Button(onClick = { viewModel.takeoff() }) {
                Text("Takeoff")
            }

            Button(onClick = { viewModel.rtl() }) {
                Text("RTL")
            }
        }
    }
}