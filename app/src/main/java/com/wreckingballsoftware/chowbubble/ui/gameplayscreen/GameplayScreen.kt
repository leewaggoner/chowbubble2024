package com.wreckingballsoftware.chowbubble.ui.gameplayscreen

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.withFrameNanos
import com.wreckingballsoftware.chowbubble.ui.navigation.NavGraph
import org.koin.androidx.compose.getViewModel

@Composable
fun GameplayScreen(navGraph: NavGraph, viewModel: GameplayViewModel = getViewModel()) {
    LaunchedEffect(key1 = Unit) {
        while (true) {
            withFrameNanos { time ->
                viewModel.game.update(time)
            }
        }
    }
    Column {
        viewModel.game.gameObject.forEach {
            Text(text = "Raw FPS: ${it.rawFps}")
            Text(text = "FPS by ticks: ${it.fps}")
        }
    }
}
