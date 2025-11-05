package com.blackboxers.blackbox

import com.blackboxers.blackbox.data.Value
import com.blackboxers.blackbox.sensor.BlackboxSensor

import java.io.Serializable
typealias BlackboxReport = Map<String, Value?>

class Blackbox {

    private val sensors = HashMap<String, BlackboxSensor<Value>>()

    fun <V: Value, S: BlackboxSensor<V>> addSensor(sensor: S): S {
        sensors.put(sensor.name, sensor)
        return sensor
    }

    fun generateReport(): BlackboxReport {
        return sensors.values.associate { it.name to it.fetch() }
    }


}