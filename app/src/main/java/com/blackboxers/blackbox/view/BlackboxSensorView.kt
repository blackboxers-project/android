package com.blackboxers.blackbox.view

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

interface BlackboxSensorView {

    val sensorName: String

    val view: @Composable (Modifier) -> Unit

}