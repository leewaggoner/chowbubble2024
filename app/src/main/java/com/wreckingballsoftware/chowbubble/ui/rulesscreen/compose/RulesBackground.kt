package com.wreckingballsoftware.chowbubble.ui.rulesscreen.compose

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
fun RulesBackground() {
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
            painter = painterResource(id = R.drawable.instructions_screen),
            contentScale = ContentScale.Inside,
            contentDescription = ""
        )
    }
}

@Preview(name = "RulesBackground Preview", showBackground = true)
@Composable
fun RulesBackgroundPreview() {
    RulesBackground()
}
