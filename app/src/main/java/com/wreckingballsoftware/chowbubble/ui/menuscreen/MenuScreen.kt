package com.wreckingballsoftware.chowbubble.ui.menuscreen

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.wreckingballsoftware.chowbubble.ui.navigation.NavGraph
import org.koin.androidx.compose.getViewModel

@Composable
fun MenuScreen(navGraph: NavGraph, viewModel: MenuViewModel = getViewModel()) {
    Column {
        Text(text = "MenuScreen")
        Button(onClick = { navGraph.navigateToGameplayScreen() }) {
            Text(text = "Play")
        }
        Button(onClick = { navGraph.navigateToRulesScreen() }) {
            Text(text = "Instructions")

        }
    }
}

