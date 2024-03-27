package com.wreckingballsoftware.chowbubble.domain.gamestates.models

sealed interface GameEvent {
    data class OnAddLife(val index: Int) : GameEvent
    data object OnGameStart : GameEvent
}
