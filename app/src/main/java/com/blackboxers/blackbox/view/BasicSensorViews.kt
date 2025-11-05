package com.blackboxers.blackbox.view

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.blackboxers.blackbox.data.FloatValue
import com.blackboxers.blackbox.data.XYZ
import com.blackboxers.blackbox.sensor.BlackboxSensor


fun xyzSensorView(
    unit: String,
    sensor: BlackboxSensor<XYZ>
): BlackboxSensorView {
    return object : AbstractSensorView<XYZ>(sensor) {
        override fun getComposableView(): @Composable ((Modifier, XYZ) -> Unit) = {
                _, it -> XYZSensorComposable(it, unit)
        }
    }
}

fun floatSensorView(
    unit: String,
    sensor: BlackboxSensor<FloatValue>
): BlackboxSensorView {
    return object : AbstractSensorView<FloatValue>(sensor) {
        override fun getComposableView(): @Composable ((Modifier, FloatValue) -> Unit) = {
                _, it -> FloatSensorComposable(it.value, unit)
        }
    }
}

@Composable
fun XYZSensorComposable(
    xyz: XYZ,
    unit: String
) {
    Text(
        text = "X: ${xyz.x} $unit\n" +
                "Y: ${xyz.y} $unit\n" +
                "Z: ${xyz.z} $unit"
    )
}

@Composable
fun FloatSensorComposable(
    value: Float,
    unit: String
) {
    Text(
        text = "$value $unit"
    )
}