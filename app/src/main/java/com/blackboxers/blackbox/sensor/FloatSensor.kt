package com.blackboxers.blackbox.sensor

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorManager

class FloatSensor(name: String, context: Context, sensorType: Int) : AbstractSensor<Float>(name, context) {
    override val sensor: Sensor = sensorManager.getDefaultSensor(sensorType)!!
    override fun onUpdate(event: SensorEvent): Float {
        return event.values[0]
    }

    init {
        bindListener()
    }
}

