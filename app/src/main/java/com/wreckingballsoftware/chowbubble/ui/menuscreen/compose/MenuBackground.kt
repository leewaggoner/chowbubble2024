package com.wreckingballsoftware.chowbubble.ui.menuscreen.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.wreckingballsoftware.chowbubble.R

@Composable
fun MenuBackground() {
    Box(
        modifier = Modifier
            .fillMaxSize(),
    ) {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(id = R.drawable.all_background),
            contentScale = ContentScale.FillBounds,
            contentDescription = ""
        )
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(id = R.drawable.introscreen),
            contentScale = ContentScale.Inside,
            contentDescription = ""
        )
    }
}

@Preview(name = "MenuBackground Preview", showBackground = true)
@Composable
fun RulesBackgroundPreview() {
    MenuBackground()
}
