package viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import data.TelemetryData
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class TelemetryViewModel : ViewModel() {

    private val _telemetry =
        MutableStateFlow(TelemetryData())

    val telemetry: StateFlow<TelemetryData> = _telemetry

    fun connect() {
        viewModelScope.launch {
            _telemetry.value =
                _telemetry.value.copy(connected = true)

            while (true) {
                delay(1000)

                _telemetry.value = _telemetry.value.copy(
                    latitude = _telemetry.value.latitude + 0.0001,
                    longitude = _telemetry.value.longitude + 0.0001,
                    altitude = _telemetry.value.altitude + 1,
                    battery = (_telemetry.value.battery - 1)
                        .coerceAtLeast(0)
                )
            }
        }
    }

    fun arm() {
        _telemetry.value =
            _telemetry.value.copy(armed = true)
    }

    fun disarm() {
        _telemetry.value =
            _telemetry.value.copy(armed = false)
    }

    fun takeoff() {
        _telemetry.value =
            _telemetry.value.copy(
                flightMode = "TAKEOFF"
            )
    }

    fun rtl() {
        _telemetry.value =
            _telemetry.value.copy(
                flightMode = "RTL"
            )
    }
}