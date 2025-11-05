package com.blackboxers.blackbox.sensor

import com.blackboxers.blackbox.data.Value

interface BlackboxSensor<out V: Value> {

    val name: String

    fun fetch(): V?

}