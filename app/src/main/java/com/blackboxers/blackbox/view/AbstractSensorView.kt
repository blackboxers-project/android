package com.blackboxers.blackbox.view

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.blackboxers.blackbox.data.Value
import com.blackboxers.blackbox.sensor.BlackboxSensor
import kotlinx.coroutines.delay

abstract class AbstractSensorView<V: Value>(private val sensor: BlackboxSensor<V>) : BlackboxSensorView {
    override val sensorName: String = sensor.name

    override val view: @Composable (Modifier) -> Unit = { modifier ->

        var value by remember { mutableStateOf<V?>(null) }

        // Coroutine that updates "value" every second
        LaunchedEffect(sensor) {
            while (true) {
                // Run potentially blocking fetch on IO dispatcher
                value = sensor.fetch()
                delay(100L)
            }
        }

        value
            ?.let { getComposableView()(modifier, it) }
            ?: run {
                getNoDataComposable()(modifier)
            }
    }

    /**
     * A composable to show when there is no data to be shown by the sensor
     */
    open fun getNoDataComposable(): @Composable (Modifier) -> Unit = {
        NoDataView(it, sensor.name)
    }

    /**
     * A composable that displays the sensor data
     */
    abstract fun getComposableView(): @Composable (Modifier, V) -> Unit

}

@Composable
fun NoDataView(modifier: Modifier = Modifier, name: String) {
    Text(text = "No Data to show for sensor $name!", modifier = modifier)
}
