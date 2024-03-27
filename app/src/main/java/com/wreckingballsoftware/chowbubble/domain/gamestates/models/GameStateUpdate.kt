package com.wreckingballsoftware.chowbubble.domain.gamestates.models

sealed interface GameStateUpdate {
    data class OnAddLife(val index: Int) : GameStateUpdate
}
