package com.blackboxers.blackbox.sensor

interface BlackboxSensor<out V> {

    fun fetch(): V?

}