package com.wreckingballsoftware.chowbubble.domain

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.setValue
import com.wreckingballsoftware.chowbubble.utils.limitedDeque

class GameObject {
    var fps by mutableLongStateOf(0L)
    var rawFps by mutableLongStateOf(0L)
    val smoother by limitedDeque<Long>(limit = 64)

    fun updateRawFps(fps: Long) {
        smoother.add(fps)
        val smoothedFps = smoother.sum() / smoother.size
        rawFps = smoothedFps
    }

    fun updateFps(ticks: Long) {
        fps = ticks
    }

    fun update() {
        //do nothing
    }

    fun render(interpolation: Double) {
        //do nothing
    }
}