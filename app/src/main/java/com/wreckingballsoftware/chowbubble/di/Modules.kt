package com.wreckingballsoftware.chowbubble.di

import com.wreckingballsoftware.chowbubble.ui.gameplayscreen.GameplayViewModel
import com.wreckingballsoftware.chowbubble.ui.menuscreen.MenuViewModel
import com.wreckingballsoftware.chowbubble.ui.resultsscreen.ResultsViewModel
import com.wreckingballsoftware.chowbubble.ui.rulesscreen.RulesViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel {
        MenuViewModel(
            handle = get(),
        )
    }

    viewModel {
        RulesViewModel(
            handle = get(),
        )
    }

    viewModel {
        GameplayViewModel(
            handle = get(),
        )
    }

    viewModel {
        ResultsViewModel(
            handle = get(),
        )
    }
}