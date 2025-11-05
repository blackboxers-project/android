package com.blackboxers.blackbox.sensor

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorManager

class XYZSensor(name: String, context: Context, sensorType: Int) :
    AbstractSensor<Triple<Float, Float, Float>>(name, context) {
    override val sensor: Sensor = sensorManager.getDefaultSensor(sensorType)!!

    override fun onUpdate(event: SensorEvent): Triple<Float, Float, Float> {
        return Triple(event.values[0], event.values[1], event.values[2])
    }

    init {
        bindListener()
    }
}

