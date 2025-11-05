package com.blackboxers.blackbox.page

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.blackboxers.blackbox.view.BlackboxSensorView


@Composable
fun BlackboxPage(sensors: List<BlackboxSensorView>, modifier: Modifier = Modifier) {
    val scrollState = rememberScrollState()

    Column(modifier = Modifier
        .fillMaxSize()
        .verticalScroll(scrollState)
        .padding(16.dp)) {
        for (sensor in sensors) {
            Column(modifier) {
                Text(sensor.name + " Sensor")
                sensor.view()(modifier)
            }
        }
    }

}