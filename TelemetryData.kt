package data

data class TelemetryData(
    val latitude: Double = 12.9716,
    val longitude: Double = 77.5946,
    val altitude: Double = 100.0,
    val battery: Int = 100,
    val flightMode: String = "STABILIZE",
    val armed: Boolean = false,
    val connected: Boolean = false
)