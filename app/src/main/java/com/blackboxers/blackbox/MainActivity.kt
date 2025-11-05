package com.blackboxers.blackbox

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorManager
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.blackboxers.blackbox.page.BlackboxPage
import com.blackboxers.blackbox.sensor.FloatSensor
import com.blackboxers.blackbox.sensor.OrientationSensor
import com.blackboxers.blackbox.sensor.RotationSensor
import com.blackboxers.blackbox.sensor.XYZSensor
import com.blackboxers.blackbox.ui.theme.BlackboxTheme
import com.blackboxers.blackbox.view.RotationSensorView
import com.blackboxers.blackbox.view.floatSensorView
import com.blackboxers.blackbox.view.xyzSensorView

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            val context = LocalContext.current

            BlackboxTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Box(Modifier.padding(innerPadding)) {
                        BlackboxMainPage(Blackbox(), context)
                    }
                }
            }
        }
    }
}

@Composable
fun BlackboxMainPage(bb: Blackbox, context: Context) {
    val sensorManager = context.getSystemService(Context.SENSOR_SERVICE) as SensorManager

    val sensors = listOf(
        RotationSensorView(RotationSensor(context)),
        xyzSensorView(
            "m/s",
            bb.addSensor(XYZSensor("Accelerometer", context, Sensor.TYPE_ACCELEROMETER))
        ),
        xyzSensorView(
            "m/s",
            bb.addSensor(XYZSensor("Gravity", context, Sensor.TYPE_GRAVITY))
        ),
        xyzSensorView(
            "m/s",
            bb.addSensor(XYZSensor("Linear Acceleration", context, Sensor.TYPE_LINEAR_ACCELERATION))
        ),
        xyzSensorView(
            "rad/s",
            bb.addSensor(XYZSensor("Gyroscope", context, Sensor.TYPE_GYROSCOPE))
        ),
        xyzSensorView(
            "sin(θ/2)",
            bb.addSensor(XYZSensor("Geomagnetic", context, Sensor.TYPE_GEOMAGNETIC_ROTATION_VECTOR))
        ),
        xyzSensorView(
            "μT",
            bb.addSensor(XYZSensor("Magnetic Field", context, Sensor.TYPE_MAGNETIC_FIELD))
        ),
        xyzSensorView(
            "°C",
            bb.addSensor(OrientationSensor)
        ),
        floatSensorView(
            "cm",
            bb.addSensor(FloatSensor("Proximity", context, Sensor.TYPE_PROXIMITY))
        ),
        floatSensorView(
            "°C",
            bb.addSensor(FloatSensor("Temperature", context, Sensor.TYPE_AMBIENT_TEMPERATURE))
        ),
        floatSensorView(
            "lumen",
            bb.addSensor(FloatSensor("Light", context, Sensor.TYPE_LIGHT))
        ),
        floatSensorView(
            "mBar",
            bb.addSensor(FloatSensor("Pressure", context, Sensor.TYPE_PRESSURE))
        ),
        floatSensorView(
            "%",
            bb.addSensor(FloatSensor("Humidity", context, Sensor.TYPE_RELATIVE_HUMIDITY))
        ),
    )

    BlackboxPage(sensors)
}