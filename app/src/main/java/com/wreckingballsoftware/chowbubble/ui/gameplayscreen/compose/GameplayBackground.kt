package com.wreckingballsoftware.chowbubble.ui.gameplayscreen.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.wreckingballsoftware.chowbubble.R
import com.wreckingballsoftware.chowbubble.ui.theme.gameplayBackgroundColor

@Composable
fun GameplayBackground(content: @Composable () -> Unit) {
    Box(
        modifier = Modifier
            .background(color = gameplayBackgroundColor)
            .fillMaxSize()
    ) {
        Image(
            modifier = Modifier
                .align(Alignment.BottomCenter),
            painter = painterResource(id = R.drawable.game_background),
            contentScale = ContentScale.Inside,
            contentDescription = "",
        )
        content()
    }
}

@Preview(name = "GameplayBackground Preview", showBackground = true)
@Composable
fun GameplayBackgroundPreview() {
    GameplayBackground { }
}
