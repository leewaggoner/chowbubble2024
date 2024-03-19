package com.wreckingballsoftware.chowbubble.ui.navigation

import androidx.navigation.NavController

class NavGraph(navController: NavController) {
    val navigateToRulesScreen: () -> Unit = {
        navController.navigate(Destinations.RulesScreen)
    }
    val navigateToGameplayScreen: () -> Unit = {
        navController.navigate(Destinations.GameplayScreen) {
            popUpTo(navController.graph.id) {
                inclusive = true
            }
            launchSingleTop = true
        }
    }
    val navigateToResultsScreen: () -> Unit = {
        navController.navigate(Destinations.ResultsScreen) {
            popUpTo(navController.graph.id) {
                inclusive = true
            }
            launchSingleTop = true
        }
    }
}