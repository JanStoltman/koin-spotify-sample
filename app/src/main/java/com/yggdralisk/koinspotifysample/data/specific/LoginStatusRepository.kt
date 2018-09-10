package com.yggdralisk.koinspotifysample.data.specific

import com.yggdralisk.koinspotifysample.data.model.LoginStatus
import com.yggdralisk.koinspotifysample.util.extension.currentTimeSec
import io.reactivex.Single

open class LoginStatusRepository(private val preferencesRepository: LoginPreferencesRepository) {
    open fun getLoginStatus(): Single<LoginStatus> =
            Single.just(
                    preferencesRepository.getTokenExpirationTS() > currentTimeSec()
                            && preferencesRepository.getAccessToken().isNotBlank()
            ).map {
                LoginStatus.fromBoolean(it)
            }
}