package com.wreckingballsoftware.chowbubble.utils

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class Vector2(val x: Double, val y: Double) : Parcelable {
    operator fun times(scale: Double) = Vector2(x * scale, y * scale)
    operator fun plus(right: Vector2) = Vector2(x + right.x, y + right.y)

    companion object {
        val ZERO = Vector2(0.0, 0.0)
        val LEFT = Vector2(-1.0, 0.0)
        val RIGHT = Vector2(1.0, 0.0)
        val UP = Vector2(0.0, -1.0)
        val DOWN = Vector2(0.0, 1.0)
    }
}
