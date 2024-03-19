package com.wreckingballsoftware.chowbubble.ui.menuscreen

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.SavedStateHandleSaveableApi
import androidx.lifecycle.viewmodel.compose.saveable
import com.wreckingballsoftware.chowbubble.ui.menuscreen.models.MenuEvent
import com.wreckingballsoftware.chowbubble.ui.menuscreen.models.MenuNavigation
import com.wreckingballsoftware.chowbubble.ui.menuscreen.models.MenuState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch

class MenuViewModel(
    handle: SavedStateHandle,
) : ViewModel() {
    @OptIn(SavedStateHandleSaveableApi::class)
    var state by handle.saveable {
        mutableStateOf(MenuState())
    }
    val navigation = MutableSharedFlow<MenuNavigation>(
        extraBufferCapacity = 1,
        onBufferOverflow = BufferOverflow.DROP_LATEST,
    )

    fun handleEvent(event: MenuEvent) {
        when (event) {
            MenuEvent.OnSoundToggle -> {
                state = state.copy(soundOn = !state.soundOn)
            }
            MenuEvent.OnPlayGame -> {
                viewModelScope.launch(Dispatchers.Main) {
                    navigation.emit(MenuNavigation.StartGame)
                }
            }
            MenuEvent.OnShowInstructions -> {
                viewModelScope.launch(Dispatchers.Main) {
                    navigation.emit(MenuNavigation.ShowRules)
                }
            }
        }
    }
}