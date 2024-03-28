package com.wreckingballsoftware.chowbubble.domain.spritedata

import com.wreckingballsoftware.chowbubble.R
import com.wreckingballsoftware.chowbubble.utils.Vector2

data class FallingObjectData(
    var foSpeed: Double = 100.0,
    var startPosition: Vector2 = Vector2.ZERO,
    var spriteId: Int = R.drawable.bubble_tea_green,
) : SpriteObject(speed = foSpeed, position = startPosition) {
    override var size = Vector2(x = 50.0, y = 50.0)
}