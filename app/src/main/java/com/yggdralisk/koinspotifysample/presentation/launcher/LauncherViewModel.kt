package com.yggdralisk.koinspotifysample.presentation.launcher

import android.app.Activity
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.yggdralisk.koinspotifysample.data.model.LoginStatus
import com.yggdralisk.koinspotifysample.domain.LoginStatusInteractor
import com.yggdralisk.koinspotifysample.presentation.login.LoginActivity
import com.yggdralisk.koinspotifysample.presentation.releases.ReleasesActivity
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import timber.log.Timber

class LauncherViewModel(private val loginStatusInteractor: LoginStatusInteractor) : ViewModel() {
    private val subscriptions = CompositeDisposable()
    private val activityToStart = MutableLiveData<Class<out Activity>>()

    override fun onCleared() {
        super.onCleared()
        subscriptions.clear()
    }

    fun getActivityToStart(): LiveData<Class<out Activity>> {
        loginStatusInteractor.getLoginStatus()
                .subscribe({
                    activityToStart.value = when (it) {
                        LoginStatus.LOGGED_IN -> ReleasesActivity::class.java
                        LoginStatus.LOGGED_OUT, null -> LoginActivity::class.java
                    }
                }, {
                    Timber.e(it)
                    activityToStart.value = LoginActivity::class.java
                }).addTo(subscriptions)

        return activityToStart
    }
}