package com.blackboxers.blackbox.view

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.blackboxers.blackbox.data.XYZ
import com.blackboxers.blackbox.sensor.RotationSensor

class RotationSensorView(sensor: RotationSensor) :
    AbstractSensorView<XYZ>(sensor) {
    override fun getComposableView(): @Composable ((Modifier, XYZ) -> Unit) {
        return { _, orientation -> RotationSensorComposable(orientation) }
    }
}


@Composable
fun RotationSensorComposable(
    orientation: XYZ
) {
    Text(
        text = "Azimuth (Z): ${orientation.x}°\n" +
                "Pitch (X): ${orientation.y}°\n" +
                "Roll (Y): ${orientation.z}°"
    )
}