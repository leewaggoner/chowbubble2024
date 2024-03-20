package com.wreckingballsoftware.chowbubble.data

import android.content.Context
import android.media.MediaPlayer
import com.wreckingballsoftware.chowbubble.R

enum class Song(val id: Int) {
    NO_SONG(-1),
    MAIN_SONG(R.raw.main_theme),
    GAMEPLAY_SONG(R.raw.main_theme)
}

class MusicPlayer(
    private val context: Context,
    private var mediaPlayer: MediaPlayer? = null
) {
    private var currentSong = Song.NO_SONG

    fun play(song: Song) {
        val isPlaying = mediaPlayer?.isPlaying ?: false
        when {
            mediaPlayer == null -> {
                //create new media player and play the theme
                mediaPlayer = MediaPlayer.create(context, song.id)
                mediaPlayer?.isLooping = true
                mediaPlayer?.start()
                currentSong = song
            }
            mediaPlayer != null && song != currentSong -> {
                //stop and switch themes
                stop()
                mediaPlayer = MediaPlayer.create(context, song.id)
                mediaPlayer?.isLooping = true
                mediaPlayer?.start()
                currentSong = song
            }
            !isPlaying -> {
                //resume playing
                mediaPlayer?.start()
            }
            else -> { /*the song is already playing -- do nothing*/ }
        }
    }

    fun pause() {
        mediaPlayer?.pause()
    }

    fun stop() {
        mediaPlayer?.stop()
        mediaPlayer?.release()
        mediaPlayer = null
        currentSong = Song.NO_SONG
    }
}