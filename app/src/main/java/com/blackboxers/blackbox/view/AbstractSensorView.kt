package com.blackboxers.blackbox.view

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.blackboxers.blackbox.sensor.BlackboxSensor

abstract class AbstractSensorView<V>(private val sensor: BlackboxSensor<V>) : BlackboxSensorView {
    override fun view(): @Composable (Modifier) -> Unit = { modifier ->
        val value: V? = sensor.fetch()

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
        NoDataView(it, name)
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
