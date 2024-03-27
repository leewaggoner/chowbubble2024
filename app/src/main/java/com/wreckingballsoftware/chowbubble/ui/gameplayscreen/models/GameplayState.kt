package com.wreckingballsoftware.chowbubble.ui.gameplayscreen.models

import com.wreckingballsoftware.chowbubble.domain.spritedata.LifeData

data class GameplayState(
    val lives: List<LifeData> = listOf(
        LifeData().apply { visible = true },
        LifeData().apply { visible = false },
        LifeData().apply { visible = false },
    ),
    val score: Int = 0,
)
