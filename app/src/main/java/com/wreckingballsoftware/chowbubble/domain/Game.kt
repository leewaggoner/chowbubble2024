package com.wreckingballsoftware.chowbubble.domain


import android.os.SystemClock

private const val ONE_SECOND_IN_NANOSECONDS = 1E9
private const val ONE_SECOND_IN_MILLISECONDS = 1000L
private const val TICKS_PER_SECOND = 34L
private const val SKIP_TICKS = ONE_SECOND_IN_MILLISECONDS / TICKS_PER_SECOND
private const val MAX_FRAMESKIP = 5

class Game {
    val gameObject = mutableListOf(GameObject())
    private var fps = 0L
    private var lastTime = 0L
    private var ticks = 0L
    private var timeAtLastFPSCheck = 0L
    private var nextGameTick = 0L
    private var other = 0L

    fun update(time: Long) {
        //display raw fps
        val delta = time - lastTime
        if (lastTime > 0L) {
            fps = (ONE_SECOND_IN_NANOSECONDS / delta).toLong()
        }
        lastTime = time
        gameObject[0].updateRawFps(fps)

        //-----------------------------------------------------------------------------------------

        //limit frames to ~SKIP_TICKS frames per second
        var loops = 0
        var curMillis = SystemClock.elapsedRealtime()
        while (curMillis > nextGameTick && loops < MAX_FRAMESKIP) {
            // In a while loop in case the process falls behind the expected time of the next update
            // then we can update the game state without rendering it. Also, the maximum number of
            // frames that can be skipped is capped so the game can render at some point
            gameObject[0].update()
            ticks++
            nextGameTick = curMillis + SKIP_TICKS
            loops++
            curMillis = SystemClock.elapsedRealtime()
        }

        val interpolation = (SystemClock.elapsedRealtime() + SKIP_TICKS - nextGameTick).toDouble() / SKIP_TICKS
        //draw game object
        gameObject[0].render(interpolation)

        if (SystemClock.elapsedRealtime() - timeAtLastFPSCheck >= ONE_SECOND_IN_MILLISECONDS) {
            gameObject[0].updateFps(ticks)
            ticks = 0
            other = 0
            timeAtLastFPSCheck = SystemClock.elapsedRealtime()
        }
    }
}
