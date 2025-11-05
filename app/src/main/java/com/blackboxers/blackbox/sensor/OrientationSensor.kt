package com.blackboxers.blackbox.sensor

import android.hardware.SensorManager
import com.blackboxers.blackbox.data.XYZ

object OrientationSensor : BlackboxSensor<XYZ> {

    private val rotationMatrix = FloatArray(9)
    private val orientationValues = FloatArray(3)

    override val name: String = "Orientation"

    override fun fetch(): XYZ {
        // Get orientation angles from rotation matrix
        SensorManager.getOrientation(rotationMatrix, orientationValues)

        // orientationValues: [azimuth(Z), pitch(X), roll(Y)]
        val azimuth = Math.toDegrees(orientationValues[0].toDouble()).toFloat()
        val pitch = Math.toDegrees(orientationValues[1].toDouble()).toFloat()
        val roll = Math.toDegrees(orientationValues[2].toDouble()).toFloat()

        return XYZ(azimuth, pitch, roll)
    }

}