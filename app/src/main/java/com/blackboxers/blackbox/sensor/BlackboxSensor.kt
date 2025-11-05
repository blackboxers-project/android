package com.blackboxers.blackbox.sensor

interface BlackboxSensor<out V> {

    val name: String

    fun fetch(): V?

}