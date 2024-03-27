package com.wreckingballsoftware.chowbubble.ui.gameplayscreen.statusbar

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.wreckingballsoftware.chowbubble.domain.spritedata.LifeData

class StatusBarViewModel(
    handle: SavedStateHandle,
) : ViewModel() {
    val lifeData1 = LifeData()
}
