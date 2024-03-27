package com.wreckingballsoftware.chowbubble.ui.gameplayscreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.withFrameNanos
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import com.wreckingballsoftware.chowbubble.ui.gameplayscreen.compose.GameplayBackground
import com.wreckingballsoftware.chowbubble.ui.gameplayscreen.models.GameplayEvent
import com.wreckingballsoftware.chowbubble.ui.gameplayscreen.models.GameplayState
import com.wreckingballsoftware.chowbubble.ui.gameplayscreen.statusbar.StatusBar
import com.wreckingballsoftware.chowbubble.ui.navigation.NavGraph
import org.koin.androidx.compose.getViewModel

@Composable
fun GameplayScreen(navGraph: NavGraph, viewModel: GameplayViewModel = getViewModel()) {
    LaunchedEffect(key1 = Unit) {
        viewModel.game.startGame()
        while (viewModel.game.playing) {
            withFrameNanos { time ->
                viewModel.game.update(time)
            }
        }
    }

    GameplayScreenContent(
        state = viewModel.state,
        onEvent = viewModel::onEvent
    )
}

@Composable
fun GameplayScreenContent(
    state: GameplayState,
    onEvent: (GameplayEvent) -> Unit,
) {
    val density = LocalDensity.current
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .onSizeChanged { size ->
                    with(density) {
                        onEvent(
                            GameplayEvent.OnSizeChanged(
                                size.width.toDp(),
                                size.height.toDp()
                            )
                        )
                    }
                },
        ) {
            Box(
                modifier = Modifier
                    .clipToBounds()
                    .fillMaxSize(),
            ) {
                GameplayBackground {
                    //gameplay content
                }
            }
            StatusBar(
                modifier = Modifier.background(color = Color.Transparent),
                lives = state.lives,
                score = state.score,
            )
        }
    }
}

@Preview(name = "GameplayScreenContent Preview", showBackground = true)
@Composable
fun GameplayScreenContentPreview() {
    GameplayScreenContent(
        state = GameplayState(),
        onEvent = { },
    )
}
