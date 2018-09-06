package com.yggdralisk.koinspotifysample.injection

import com.yggdralisk.koinspotifysample.presentation.launcher.LauncherViewModel
import org.koin.androidx.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

val launcherModule = module {
    viewModel { LauncherViewModel(get()) }
}