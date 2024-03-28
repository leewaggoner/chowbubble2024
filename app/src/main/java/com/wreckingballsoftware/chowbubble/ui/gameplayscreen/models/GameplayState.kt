package com.wreckingballsoftware.chowbubble.ui.gameplayscreen.models

import androidx.compose.runtime.mutableStateListOf
import com.wreckingballsoftware.chowbubble.domain.spritedata.LifeData
import com.wreckingballsoftware.chowbubble.domain.spritedata.SpriteObject

data class GameplayState(
    val lives: List<LifeData> = mutableStateListOf(
        LifeData().apply { visible = false },
        LifeData().apply { visible = false },
        LifeData().apply { visible = false },
    ),
    val score: Int = 0,
    val sprites: List<SpriteObject> = listOf(),
)
