package com.yggdralisk.koinspotifysample.presentation.launcher

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.yggdralisk.koinspotifysample.data.model.LoginStatus
import com.yggdralisk.koinspotifysample.domain.LoginStatusInteractor
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import timber.log.Timber

class LauncherViewModel(private val loginStatusInteractor: LoginStatusInteractor) : ViewModel() {
    private val subscriptions = CompositeDisposable()
    private val loginStatus = MutableLiveData<LoginStatus>()

    fun getLoginStatus(): LiveData<LoginStatus> {
        loginStatusInteractor.getLoginStatus()
                .subscribe({
                    loginStatus.value = it
                }, {
                    Timber.e(it)
                    loginStatus.value = LoginStatus.LOGGED_OUT
                }).addTo(subscriptions)

        return loginStatus
    }

    override fun onCleared() {
        super.onCleared()
        subscriptions.clear()
    }
}