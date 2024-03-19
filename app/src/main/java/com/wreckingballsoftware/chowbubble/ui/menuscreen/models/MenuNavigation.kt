package com.wreckingballsoftware.chowbubble.ui.menuscreen.models

sealed interface MenuNavigation {
    data object StartGame : MenuNavigation
    data object ShowRules : MenuNavigation
}