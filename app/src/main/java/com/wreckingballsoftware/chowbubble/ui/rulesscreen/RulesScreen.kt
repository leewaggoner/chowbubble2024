package com.wreckingballsoftware.chowbubble.ui.rulesscreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.wreckingballsoftware.chowbubble.ui.rulesscreen.compose.RulesBackground

@Composable
fun RulesScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
    ) {
        RulesBackground()
    }
}

