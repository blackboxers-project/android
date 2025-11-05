package com.blackboxers.blackbox.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
sealed interface Value

@Serializable
@SerialName("XYZ")
data class XYZ(
    val x: Float,
    val y: Float,
    val z: Float
): Value

@Serializable
@SerialName("Float")
data class FloatValue(val value: Float): Value