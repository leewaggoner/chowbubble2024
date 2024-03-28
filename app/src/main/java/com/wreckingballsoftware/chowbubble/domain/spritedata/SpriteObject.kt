package com.wreckingballsoftware.chowbubble.domain.spritedata

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.wreckingballsoftware.chowbubble.utils.Vector2

sealed class SpriteObject(
    speed: Double = 0.0,
    angle: Vector2 = Vector2.DOWN,
    position: Vector2 = Vector2.ZERO
) {
    abstract var size: Vector2
    var speed by mutableDoubleStateOf(speed)
    var angle by mutableStateOf(angle)
    var position by mutableStateOf(position)
    private val movementVector: Vector2
        get() = angle * speed
    val xOffset: Dp
        get() = position.x.dp - (size.x.dp / 2)
    val yOffset: Dp
        get() = position.y.dp - (size.y.dp / 2)

    fun update(delta: Float) {
        val velocity = movementVector * delta.toDouble()
        position += velocity
    }
}
