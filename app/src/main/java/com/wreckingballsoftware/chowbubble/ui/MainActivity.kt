package com.wreckingballsoftware.chowbubble.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.wreckingballsoftware.chowbubble.data.AudioPlayer
import com.wreckingballsoftware.chowbubble.ui.navigation.ChowHost
import com.wreckingballsoftware.chowbubble.ui.theme.ChowBubbleTheme
import org.koin.android.ext.android.inject

class MainActivity : ComponentActivity() {
    private val audioPlayer: AudioPlayer by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ChowBubbleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ChowHost()
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        audioPlayer.release()
    }
}

