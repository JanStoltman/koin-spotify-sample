package com.yggdralisk.koinspotifysample.injection

import com.yggdralisk.koinspotifysample.MyApplication
import com.yggdralisk.koinspotifysample.data.common.SharedPreferencesRepository
import com.yggdralisk.koinspotifysample.data.specific.LoginRepository
import com.yggdralisk.koinspotifysample.data.specific.LoginStatusRepository
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module.module

val repositoryModule = module {
    single { LoginStatusRepository(get()) }
    single {
        SharedPreferencesRepository(
                this.androidContext().getSharedPreferences(
                        MyApplication.SHARED_PREF_NAME, MyApplication.SHARED_PREF_MODE
                )
        )
    }
    single {
        LoginRepository(this.androidContext())
    }
}