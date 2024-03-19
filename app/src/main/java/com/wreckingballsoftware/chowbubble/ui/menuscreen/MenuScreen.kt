package com.wreckingballsoftware.chowbubble.ui.menuscreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.wreckingballsoftware.chowbubble.ui.menuscreen.compose.AudioButton
import com.wreckingballsoftware.chowbubble.ui.menuscreen.compose.InstructionsButton
import com.wreckingballsoftware.chowbubble.ui.menuscreen.compose.MenuBackground
import com.wreckingballsoftware.chowbubble.ui.menuscreen.compose.PlayButton
import com.wreckingballsoftware.chowbubble.ui.menuscreen.models.MenuEvent
import com.wreckingballsoftware.chowbubble.ui.menuscreen.models.MenuNavigation
import com.wreckingballsoftware.chowbubble.ui.menuscreen.models.MenuState
import com.wreckingballsoftware.chowbubble.ui.navigation.NavGraph
import org.koin.androidx.compose.getViewModel

@Composable
fun MenuScreen(navGraph: NavGraph, viewModel: MenuViewModel = getViewModel()) {
    val navigation = viewModel.navigation.collectAsStateWithLifecycle(null)
    navigation.value?.let { nav ->
        when (nav) {
            MenuNavigation.StartGame -> navGraph.navigateToGameplayScreen()
            MenuNavigation.ShowRules -> navGraph.navigateToRulesScreen()
        }
    }

    MenuScreenContent(
        viewModel.state,
        viewModel::handleEvent,
    )
}

@Composable
fun MenuScreenContent(
    state: MenuState,
    handleEvent: (MenuEvent) -> Unit,
) {
    MenuBackground()
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize(),
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .fillMaxSize(),
            horizontalAlignment = Alignment.End
        ) {
            AudioButton(audioOn = state.soundOn) {
                handleEvent(MenuEvent.OnSoundToggle)
            }
        }
        Row(
            modifier = Modifier
                .padding(bottom = 16.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            PlayButton {
                handleEvent(MenuEvent.OnPlayGame)
            }
            InstructionsButton {
                handleEvent(MenuEvent.OnShowInstructions)
            }
        }
    }
}

@Preview(name = "MenuScreenContent Preview", showBackground = true)
@Composable
fun MenuScreenContentPreview() {
    MenuScreenContent(
        state = MenuState(),
        handleEvent = { }
    )
}