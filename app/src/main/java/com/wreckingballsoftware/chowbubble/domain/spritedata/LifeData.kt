package com.wreckingballsoftware.chowbubble.domain.spritedata

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.wreckingballsoftware.chowbubble.utils.Vector2

class LifeData(
    full: Boolean = true,
    visible: Boolean = true
) : SpriteObject() {
    var full by mutableStateOf(full)
    var visible by mutableStateOf(visible)
    override var size = Vector2(x = 30.0, y = 50.0)
}
