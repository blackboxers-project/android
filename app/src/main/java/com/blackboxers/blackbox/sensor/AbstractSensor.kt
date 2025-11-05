package com.blackboxers.blackbox.sensor

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager

abstract class AbstractSensor<out V>(
    override val name: String,
    context: Context
) : BlackboxSensor<V> {

    protected val sensorManager = context.getSystemService(Context.SENSOR_SERVICE) as SensorManager

    protected abstract val sensor: Sensor

    private val listener = object : SensorEventListener {
        override fun onSensorChanged(sensorEvent: SensorEvent) {
            valueBuff = onUpdate(sensorEvent)
        }

        override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) = Unit
    }

    private var valueBuff: V? = null

    protected fun bindListener() {
        sensorManager.registerListener(listener, sensor, SensorManager.SENSOR_DELAY_UI)
    }

    protected fun unbindListener() {
        sensorManager.unregisterListener(listener)
    }


    abstract fun onUpdate(event: SensorEvent): V

    override fun fetch(): V? = valueBuff
}