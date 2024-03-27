package com.wreckingballsoftware.chowbubble.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.core.handlers.ReplaceFileCorruptionHandler
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.preferencesDataStoreFile
import com.wreckingballsoftware.chowbubble.data.AudioPlayer
import com.wreckingballsoftware.chowbubble.data.DataStoreWrapper
import com.wreckingballsoftware.chowbubble.data.MusicPlayer
import com.wreckingballsoftware.chowbubble.domain.Game
import com.wreckingballsoftware.chowbubble.ui.gameplayscreen.GameplayViewModel
import com.wreckingballsoftware.chowbubble.ui.gameplayscreen.statusbar.StatusBarViewModel
import com.wreckingballsoftware.chowbubble.ui.menuscreen.MenuViewModel
import com.wreckingballsoftware.chowbubble.ui.resultsscreen.ResultsViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

private const val DATA_STORE_NAME = "com.wreckingballsoftware.chowbubble"

val appModule = module {
    viewModel {
        MenuViewModel(
            handle = get(),
            audioPlayer = get(),
            dataStoreWrapper = get(),
        )
    }

    viewModel {
        GameplayViewModel(
            handle = get(),
            game = get(),
        )
    }

    viewModel {
        StatusBarViewModel(
            handle = get(),
        )
    }

    viewModel {
        ResultsViewModel(
            handle = get(),
        )
    }

    single {
        Game()
    }

    single {
        AudioPlayer(
            musicPlayer = get(),
        )
    }

    single {
        MusicPlayer(androidContext())
    }

    single {
        DataStoreWrapper(getDataStore(androidContext()))
    }
}


private fun getDataStore(context: Context) : DataStore<Preferences> =
    PreferenceDataStoreFactory.create(
        corruptionHandler = ReplaceFileCorruptionHandler(produceNewData = { emptyPreferences() }),
        produceFile = { context.preferencesDataStoreFile(DATA_STORE_NAME) },
        scope = CoroutineScope(Dispatchers.IO + SupervisorJob())
    )
