package com.yggdralisk.koinspotifysample

import android.app.Application
import android.content.Context
import com.yggdralisk.koinspotifysample.injection.interactorModule
import com.yggdralisk.koinspotifysample.injection.launcherModule
import com.yggdralisk.koinspotifysample.injection.repositoryModule
import org.koin.android.ext.android.startKoin
import timber.log.Timber

class MyApplication : Application() {
    companion object {
        const val SHARED_PREF_NAME = "MY_SHARES"
        const val SHARED_PREF_MODE = Context.MODE_PRIVATE
    }

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }

        startKoin(this, listOf(launcherModule, interactorModule, repositoryModule))
    }
}