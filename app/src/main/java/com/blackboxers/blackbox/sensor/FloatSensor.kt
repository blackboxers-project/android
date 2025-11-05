package com.blackboxers.blackbox.sensor

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorManager
import com.blackboxers.blackbox.data.FloatValue

class FloatSensor(name: String, context: Context, sensorType: Int) : AbstractSensor<FloatValue>(name, context) {
    override val sensor: Sensor = sensorManager.getDefaultSensor(sensorType)!!
    override fun onUpdate(event: SensorEvent): FloatValue {
        return FloatValue(event.values[0])
    }

    init {
        bindListener()
    }
}

