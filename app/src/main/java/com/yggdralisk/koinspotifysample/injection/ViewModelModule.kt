package com.yggdralisk.koinspotifysample.injection

import com.yggdralisk.koinspotifysample.presentation.launcher.LauncherViewModel
import com.yggdralisk.koinspotifysample.presentation.login.LoginViewModel
import com.yggdralisk.koinspotifysample.presentation.release.ReleaseDetailsViewModel
import com.yggdralisk.koinspotifysample.presentation.releases.ReleasesViewModel
import com.yggdralisk.koinspotifysample.presentation.user.UserProfileViewModel
import org.koin.androidx.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

val viewModelModule = module {
    viewModel { LauncherViewModel(get()) }
    viewModel { ReleasesViewModel(get()) }
    viewModel { LoginViewModel(get()) }
    viewModel { ReleaseDetailsViewModel() }
    viewModel { UserProfileViewModel(get()) }
}