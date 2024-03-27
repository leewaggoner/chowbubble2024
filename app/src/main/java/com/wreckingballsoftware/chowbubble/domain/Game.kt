package com.wreckingballsoftware.chowbubble.domain

import androidx.compose.ui.unit.dp
import com.wreckingballsoftware.chowbubble.domain.gamestates.GameState
import com.wreckingballsoftware.chowbubble.domain.gamestates.GameStateStart
import com.wreckingballsoftware.chowbubble.domain.gamestates.models.GameEvent
import com.wreckingballsoftware.chowbubble.domain.gamestates.models.GameStateUpdate


private const val ONE_SECOND_IN_NANOSECONDS = 1E9

class Game {
    private var lastTime = 0L
    private var onGameEvent: ((GameEvent) -> Unit)? = null
    private var onGameStateUpdate: ((GameStateUpdate) -> Unit)? = null
    private var gameState: GameState? = null
    var width = 0.dp
    var height = 0.dp

    init {
        lastTime = System.nanoTime()
    }

    fun setOnGameplayEventCallback(onGameEvent: (GameEvent) -> Unit) {
        this.onGameEvent = onGameEvent
    }

    fun setOnGameStateUpdateCallback(onGameStateUpdate: (GameStateUpdate) -> Unit) {
        this.onGameStateUpdate = onGameStateUpdate
    }

    var playing: Boolean = false
        private set
//    val spriteObject = mutableListOf(LifeData())

    fun startGame() {
        playing = true
        gameState = GameStateStart().apply {
            setGameEventCallback { event ->
                onGameEvent(event)
            }
            onStart()
        }
    }

    fun update(time: Long) {
        val delta = time - lastTime
        val renderDelta = (delta / ONE_SECOND_IN_NANOSECONDS).toFloat()
        lastTime = time
        gameState?.onUpdate(time, false, 0f)
//        spriteObject[0].update(renderDelta)
    }

    private fun onGameEvent(event: GameEvent) {
        when (event) {
            GameEvent.OnGameStart -> {
//                gameState = GameStatePlay()
            }
            is GameEvent.OnAddLife -> {
                onGameStateUpdate?.let { it(GameStateUpdate.OnAddLife(event.index)) }
            }
        }
    }

    fun endGame() {
        playing = false
    }
}
