package com.wreckingballsoftware.chowbubble.ui.menuscreen

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.SavedStateHandleSaveableApi
import androidx.lifecycle.viewmodel.compose.saveable
import com.wreckingballsoftware.chowbubble.data.AudioPlayer
import com.wreckingballsoftware.chowbubble.data.DataStoreWrapper
import com.wreckingballsoftware.chowbubble.ui.menuscreen.models.MenuEvent
import com.wreckingballsoftware.chowbubble.ui.menuscreen.models.MenuNavigation
import com.wreckingballsoftware.chowbubble.ui.menuscreen.models.MenuState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch

class MenuViewModel(
    handle: SavedStateHandle,
    private val audioPlayer: AudioPlayer,
    private val dataStoreWrapper: DataStoreWrapper,
) : ViewModel() {
    @OptIn(SavedStateHandleSaveableApi::class)
    var state by handle.saveable {
        mutableStateOf(MenuState())
    }
    val navigation = MutableSharedFlow<MenuNavigation>(
        extraBufferCapacity = 1,
        onBufferOverflow = BufferOverflow.DROP_LATEST,
    )

    fun initAudioStatus() {
        viewModelScope.launch(Dispatchers.Main) {
            val audioOn = dataStoreWrapper.getAudioStatus(true)
            handleEvent(MenuEvent.OnAudioStatusChanged(audioOn))
        }
    }

    fun handleEvent(event: MenuEvent) {
        when (event) {
            is MenuEvent.OnAudioStatusChanged -> {
                viewModelScope.launch {
                    dataStoreWrapper.putAudioStatus(event.audioStatus)
                }
                audioPlayer.setAudioStatus(event.audioStatus)
                state = state.copy(soundOn = event.audioStatus)
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