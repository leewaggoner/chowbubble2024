package com.wreckingballsoftware.chowbubble.domain

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.ui.unit.dp
import com.wreckingballsoftware.chowbubble.R
import com.wreckingballsoftware.chowbubble.domain.gamestates.GameState
import com.wreckingballsoftware.chowbubble.domain.gamestates.GameStateStart
import com.wreckingballsoftware.chowbubble.domain.gamestates.models.GameEvent
import com.wreckingballsoftware.chowbubble.domain.gamestates.models.GameStateUpdate
import com.wreckingballsoftware.chowbubble.domain.spritedata.FallingObjectData
import com.wreckingballsoftware.chowbubble.domain.spritedata.SpriteObject
import com.wreckingballsoftware.chowbubble.utils.Vector2


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
    val spriteObject: List<SpriteObject> = mutableStateListOf(FallingObjectData().apply {spriteId = R.drawable.bubble_tea_green })

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
        spriteObject.forEach {
            it.update(renderDelta)
            if (it.position.y > height.value) {
                it.position = Vector2.ZERO
            }
        }
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
