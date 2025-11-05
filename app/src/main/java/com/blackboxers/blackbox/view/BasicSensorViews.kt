package com.blackboxers.blackbox.view

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.blackboxers.blackbox.sensor.BlackboxSensor


fun xyzSensorView(
    name: String,
    unit: String,
    sensor: BlackboxSensor<Triple<Number, Number, Number>>
): BlackboxSensorView {
    return object : AbstractSensorView<Triple<Number, Number, Number>>(sensor) {
        override val name: String = name

        override fun getComposableView(): @Composable ((Modifier, Triple<Number, Number, Number>) -> Unit) = {
                _, it -> XYZSensorComposable(it, unit)
        }
    }
}

fun floatSensorView(
    name: String,
    unit: String,
    sensor: BlackboxSensor<Float>
): BlackboxSensorView {
    return object : AbstractSensorView<Float>(sensor) {
        override val name: String = name

        override fun getComposableView(): @Composable ((Modifier, Float) -> Unit) = {
                _, it -> FloatSensorComposable(it, unit)
        }
    }
}

@Composable
fun XYZSensorComposable(
    xyz: Triple<Number, Number, Number>,
    unit: String
) {
    Text(
        text = "X: ${xyz.first} $unit\n" +
                "Y: ${xyz.second} $unit\n" +
                "Z: ${xyz.third} $unit"
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