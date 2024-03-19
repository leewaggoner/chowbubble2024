package com.wreckingballsoftware.chowbubble.ui.gameplayscreen

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.wreckingballsoftware.chowbubble.ui.navigation.NavGraph
import org.koin.androidx.compose.getViewModel

@Composable
fun GameplayScreen(navGraph: NavGraph, viewModel: GameplayViewModel = getViewModel()) {
    Column {
        Text(text = "GameplayScreen")
        Button(onClick = { navGraph.navigateToResultsScreen() }) {
            Text(text = "Game Over")
        }
    }
}
