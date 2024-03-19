package com.wreckingballsoftware.chowbubble.ui.resultsscreen

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.wreckingballsoftware.chowbubble.ui.navigation.NavGraph
import org.koin.androidx.compose.getViewModel

@Composable
fun ResultsScreen(navGraph: NavGraph, viewModel: ResultsViewModel = getViewModel()) {
    Column {
        Text(text = "ResultsScreen")
        Button(onClick = { navGraph.navigateToGameplayScreen() }) {
            Text(text = "Play Again")
        }
        Button(onClick = { navGraph.navigateToRulesScreen() }) {
            Text(text = "Instructions")

        }
    }
}
