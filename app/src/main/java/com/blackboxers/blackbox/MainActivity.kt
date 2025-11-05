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
                        BlackboxMainPage(context)
                    }
                }
            }
        }
    }
}

@Composable
fun BlackboxMainPage(context: Context) {
    val sensorManager = context.getSystemService(Context.SENSOR_SERVICE) as SensorManager

    val sensors = listOf(
        RotationSensorView(RotationSensor(context)),
        xyzSensorView(
            "Accelerometer",
            "m/s",
            XYZSensor(context, Sensor.TYPE_ACCELEROMETER)
        ),
        xyzSensorView(
            "Gravity",
            "m/s",
            XYZSensor(context, Sensor.TYPE_GRAVITY)
        ),
        xyzSensorView(
            "Linear Acceleration",
            "m/s",
            XYZSensor(context, Sensor.TYPE_LINEAR_ACCELERATION)
        ),
        xyzSensorView(
            "Gyroscope",
            "rad/s",
            XYZSensor(context, Sensor.TYPE_GYROSCOPE)
        ),
        xyzSensorView(
            "Geomagnetic",
            "sin(θ/2)",
            XYZSensor(context, Sensor.TYPE_GEOMAGNETIC_ROTATION_VECTOR)
        ),
        xyzSensorView(
            "Magnetic Field",
            "μT",
            XYZSensor(context, Sensor.TYPE_MAGNETIC_FIELD)
        ),
        xyzSensorView(
            "Orientation",
            "°C",
            OrientationSensor
        ),
        floatSensorView(
            "Proximity",
            "cm",
            FloatSensor(context, Sensor.TYPE_PROXIMITY)
        ),
        floatSensorView(
            "Temperature", "°C",
            FloatSensor(context, Sensor.TYPE_AMBIENT_TEMPERATURE)
        ),
        floatSensorView(
            "Light", "lumen",
            FloatSensor(context, Sensor.TYPE_LIGHT)
        ),
        floatSensorView(
            "Pressure", "mBar",
            FloatSensor(context, Sensor.TYPE_PRESSURE)
        ),
        floatSensorView(
            "Humidity", "%",
            FloatSensor(context, Sensor.TYPE_RELATIVE_HUMIDITY)
        ),
    )

    BlackboxPage(sensors)
}