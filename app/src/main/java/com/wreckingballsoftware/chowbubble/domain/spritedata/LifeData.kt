package com.wreckingballsoftware.chowbubble.domain.spritedata

import com.wreckingballsoftware.chowbubble.utils.Vector2

data class LifeData(
    var full: Boolean = true,
    var visible: Boolean = true
) : SpriteObject() {
    override var size = Vector2(x = 30.0, y = 50.0)
}
