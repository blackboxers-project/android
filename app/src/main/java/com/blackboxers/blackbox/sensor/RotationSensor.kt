package com.blackboxers.blackbox.sensor

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorManager
import com.blackboxers.blackbox.data.XYZ

class RotationSensor(context: Context) : AbstractSensor<XYZ>("Orientation", context) {

    val rotationMatrix = FloatArray(9)
    val orientationValues = FloatArray(3)

    override val sensor: Sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ROTATION_VECTOR)!!

    override fun onUpdate(event: SensorEvent): XYZ {
        SensorManager.getRotationMatrixFromVector(rotationMatrix, event.values)
        SensorManager.getOrientation(rotationMatrix, orientationValues)

        val azimuth = Math.toDegrees(orientationValues[0].toDouble()).toFloat() // Z axis
        val pitch = Math.toDegrees(orientationValues[1].toDouble()).toFloat()   // X axis
        val roll = Math.toDegrees(orientationValues[2].toDouble()).toFloat()    // Y axis

        return XYZ(azimuth, pitch, roll)
    }

    init {
        bindListener()
    }
}

