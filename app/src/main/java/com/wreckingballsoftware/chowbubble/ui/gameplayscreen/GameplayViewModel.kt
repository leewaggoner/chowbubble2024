package com.wreckingballsoftware.chowbubble.ui.gameplayscreen

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.SavedStateHandleSaveableApi
import androidx.lifecycle.viewmodel.compose.saveable
import com.wreckingballsoftware.chowbubble.domain.Game
import com.wreckingballsoftware.chowbubble.domain.gamestates.models.GameStateUpdate
import com.wreckingballsoftware.chowbubble.ui.gameplayscreen.models.GameplayEvent
import com.wreckingballsoftware.chowbubble.ui.gameplayscreen.models.GameplayState

class GameplayViewModel(
    handle: SavedStateHandle,
    val game: Game
) : ViewModel() {
    @OptIn(SavedStateHandleSaveableApi::class)
    var state by handle.saveable {
        mutableStateOf(GameplayState())
    }

    val spriteObjects = game.spriteObject

    init {
        game.setOnGameStateUpdateCallback { event ->
            onGameStateUpdate(event)
        }
    }

    fun onEvent(event: GameplayEvent) {
        when (event) {
            is GameplayEvent.OnSizeChanged -> {
                game.width = event.width
                game.height = event.height
            }
        }
    }

    private fun onGameStateUpdate(event: GameStateUpdate) {
        when (event) {
            is GameStateUpdate.OnAddLife -> {
                val lives = state.lives
                lives[event.index].visible = true
                state = state.copy(lives = lives)
            }
        }
    }
}
