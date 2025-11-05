package com.blackboxers.blackbox.sensor

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import com.blackboxers.blackbox.data.XYZ

class XYZSensor(name: String, context: Context, sensorType: Int) :
    AbstractSensor<XYZ>(name, context) {
    override val sensor: Sensor = sensorManager.getDefaultSensor(sensorType)!!

    override fun onUpdate(event: SensorEvent): XYZ {
        return XYZ(event.values[0], event.values[1], event.values[2])
    }

    init {
        bindListener()
    }
}

