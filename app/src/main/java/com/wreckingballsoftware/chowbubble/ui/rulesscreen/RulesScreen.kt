package com.wreckingballsoftware.chowbubble.ui.rulesscreen

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.wreckingballsoftware.chowbubble.ui.navigation.NavGraph
import org.koin.androidx.compose.getViewModel

@Composable
fun RulesScreen(navGraph: NavGraph, viewModel: RulesViewModel = getViewModel()) {
    Column {
        Text(text = "RulesScreen")
        Button(onClick = { navGraph.navigateToGameplayScreen() }) {
            Text(text = "Play")
        }
    }
}

