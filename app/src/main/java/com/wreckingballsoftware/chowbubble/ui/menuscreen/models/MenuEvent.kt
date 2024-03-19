package com.wreckingballsoftware.chowbubble.ui.menuscreen.models

sealed interface MenuEvent {
    data object OnPlayGame : MenuEvent
    data object OnShowInstructions : MenuEvent
    data object OnSoundToggle : MenuEvent
}