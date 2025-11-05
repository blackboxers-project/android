package com.blackboxers.blackbox

import com.blackboxers.blackbox.sensor.BlackboxSensor
import java.io.Serializable

class Blackbox {

    private val sensors = ArrayList<BlackboxSensor<Serializable>>()

    fun <V: Serializable> addSensor(sensor: BlackboxSensor<V>) = {
        sensors.add(sensor)
    }



}