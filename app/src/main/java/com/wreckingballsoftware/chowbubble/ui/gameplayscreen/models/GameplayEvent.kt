package com.wreckingballsoftware.chowbubble.ui.gameplayscreen.models

import androidx.compose.ui.unit.Dp

interface GameplayEvent {
    data class OnSizeChanged(val width: Dp, val height: Dp) : GameplayEvent
}
