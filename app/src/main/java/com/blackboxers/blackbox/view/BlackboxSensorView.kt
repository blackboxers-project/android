package com.blackboxers.blackbox.view

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

interface BlackboxSensorView {

    val name: String

    fun view(): @Composable (Modifier) -> Unit

}