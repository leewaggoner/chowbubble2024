package com.wreckingballsoftware.chowbubble.domain.gamestates

interface GameState {
    fun onStart()
    fun onUpdate(time: Long, touchDown: Boolean, touchX: Float)
    fun onDraw()
}
