package com.yggdralisk.koinspotifysample.data.specific

import androidx.annotation.VisibleForTesting
import com.yggdralisk.koinspotifysample.data.base.SharedPreferencesRepository
import com.yggdralisk.koinspotifysample.data.model.LoginStatus
import io.reactivex.Single

open class LoginStatusRepository(private val sharedPreferencesRepository: SharedPreferencesRepository) {
    companion object {
        @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
        const val LOGIN_STATUS_PREF = "LOGIN_STATUS_PREF"
    }

    open fun getLoginStatus(): Single<LoginStatus> =
            Single.just(
                    sharedPreferencesRepository.getBoolean(LOGIN_STATUS_PREF, false)
            ).map {
                LoginStatus.fromBoolean(it)
            }
}