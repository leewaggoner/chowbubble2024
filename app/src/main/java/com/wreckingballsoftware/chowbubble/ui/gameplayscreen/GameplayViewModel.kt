package com.wreckingballsoftware.chowbubble.ui.gameplayscreen

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.wreckingballsoftware.chowbubble.domain.Game

class GameplayViewModel(
    handle: SavedStateHandle,
    val game: Game
) : ViewModel() {
}