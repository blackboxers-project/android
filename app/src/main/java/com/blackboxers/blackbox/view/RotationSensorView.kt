package com.blackboxers.blackbox.view

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.blackboxers.blackbox.sensor.RotationSensor

class RotationSensorView(sensor: RotationSensor) :
    AbstractSensorView<Triple<Float, Float, Float>>(sensor) {
    override val name: String = "Rotation"

    override fun getComposableView(): @Composable ((Modifier, Triple<Float, Float, Float>) -> Unit) {
        return { _, orientation -> RotationSensorComposable(orientation) }
    }
}


@Composable
fun RotationSensorComposable(
    orientation: Triple<Float, Float, Float>
) {
    Text(
        text = "Azimuth (Z): ${orientation.first}°\n" +
                "Pitch (X): ${orientation.second}°\n" +
                "Roll (Y): ${orientation.third}°"
    )
}