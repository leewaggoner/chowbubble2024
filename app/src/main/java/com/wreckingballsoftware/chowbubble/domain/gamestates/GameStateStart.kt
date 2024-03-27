package com.wreckingballsoftware.chowbubble.domain.gamestates

import android.os.SystemClock
import com.wreckingballsoftware.chowbubble.domain.gamestates.models.GameEvent

private const val MAX_LIVES = 3
private const val LIFE_POP_INTERVAL = 5E8

class GameStateStart : GameState {
    private var lifePopInterval: Double = 0.0
    private var lives = 0
    private var onGameEvent: ((GameEvent) -> Unit)? = null
    private var gameStarted: Boolean = false

    override fun onStart() {
        lives = 0
        lifePopInterval = SystemClock.elapsedRealtimeNanos() + LIFE_POP_INTERVAL
    }

    fun setGameEventCallback(onGameEvent: (GameEvent) -> Unit) {
        this.onGameEvent = onGameEvent
    }

    override fun onUpdate(time: Long, touchDown: Boolean, touchX: Float) {
        val currentTime = SystemClock.elapsedRealtimeNanos()
        if (currentTime > lifePopInterval) {
            lifePopInterval = SystemClock.elapsedRealtimeNanos() + LIFE_POP_INTERVAL
            if (lives < MAX_LIVES) {
                onGameEvent?.let { it(GameEvent.OnAddLife(lives)) }
                lives++
            } else {
                if (!gameStarted) {
                    gameStarted = true
                    onGameEvent?.let { it(GameEvent.OnGameStart) }
                }
            }
        }
    }

    override fun onDraw() {
    }
}
