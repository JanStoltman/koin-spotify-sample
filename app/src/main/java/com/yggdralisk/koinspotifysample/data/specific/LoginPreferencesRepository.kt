package com.yggdralisk.koinspotifysample.data.specific

import androidx.annotation.VisibleForTesting
import com.yggdralisk.koinspotifysample.data.common.SharedPreferencesRepository
import com.yggdralisk.koinspotifysample.util.extension.currentTimeSec

open class LoginPreferencesRepository(private val preferencesRepository: SharedPreferencesRepository) {
    companion object {
        @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
        const val LOGIN_ACCESS_TOKEN_PREF = "LOGIN_ACCESS_TOKEN_PREF"

        @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
        const val LOGIN_EXPIRE_TS_PREF = "LOGIN_EXPIRE_TS_PREF"
    }

    open fun getAccessToken(): String =
            preferencesRepository.getString(LOGIN_ACCESS_TOKEN_PREF, "")

    open fun getTokenExpirationTS(): Long =
            preferencesRepository.getLong(LOGIN_EXPIRE_TS_PREF, 0)

    open fun saveLoginData(accessToken: String, expiresIn: Long) {
        preferencesRepository.putString(LOGIN_ACCESS_TOKEN_PREF, accessToken)
        preferencesRepository.putLong(LOGIN_EXPIRE_TS_PREF, expiresIn + currentTimeSec())
    }
}