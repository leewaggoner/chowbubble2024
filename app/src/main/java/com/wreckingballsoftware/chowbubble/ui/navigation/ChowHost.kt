package com.wreckingballsoftware.chowbubble.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.wreckingballsoftware.chowbubble.ui.gameplayscreen.GameplayScreen
import com.wreckingballsoftware.chowbubble.ui.menuscreen.MenuScreen
import com.wreckingballsoftware.chowbubble.ui.resultsscreen.ResultsScreen
import com.wreckingballsoftware.chowbubble.ui.rulesscreen.RulesScreen

@Composable
fun ChowHost() {
    val navController = rememberNavController()
    val navGraph = remember(navController) { NavGraph(navController) }

    val startDestination = Destinations.MenuScreen

    NavHost(navController = navController, startDestination = startDestination) {
        composable(route = Destinations.MenuScreen) {
            MenuScreen(navGraph = navGraph)
        }

        composable(route = Destinations.RulesScreen) {
            RulesScreen(navGraph = navGraph)
        }

        composable(route = Destinations.GameplayScreen) {
            GameplayScreen(navGraph = navGraph)
        }

        composable(route = Destinations.ResultsScreen) { backstackEntry ->
            ResultsScreen(navGraph = navGraph)
        }
    }
}