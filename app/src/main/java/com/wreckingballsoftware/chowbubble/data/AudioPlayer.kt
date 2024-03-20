package com.wreckingballsoftware.chowbubble.data

class AudioPlayer(
    private val musicPlayer: MusicPlayer
) {
    var audioOn = true
        private set

    fun setAudioStatus(on: Boolean) {
        audioOn = on
        if (audioOn) {
            musicPlayer.play(Song.MAIN_SONG)
        } else {
            musicPlayer.pause()
        }
    }

    fun playMenuMusic() {
        if (audioOn) {
            musicPlayer.play(Song.MAIN_SONG)
        }
    }

    fun playGameplayMusic() {
        if (audioOn) {
            musicPlayer.play(Song.GAMEPLAY_SONG)
        }
    }

    fun release() {
        musicPlayer.stop()
    }

    fun playSoundEffect() {
        //play sound effect
    }
}