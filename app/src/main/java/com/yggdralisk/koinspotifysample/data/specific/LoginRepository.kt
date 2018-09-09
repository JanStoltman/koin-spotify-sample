package com.yggdralisk.koinspotifysample.data.specific

import android.app.Activity
import android.content.Context
import com.spotify.sdk.android.authentication.AuthenticationClient
import com.spotify.sdk.android.authentication.AuthenticationRequest
import com.spotify.sdk.android.authentication.AuthenticationResponse.Type
import com.yggdralisk.koinspotifysample.R
import io.reactivex.Completable
import timber.log.Timber

open class LoginRepository(private val context: Context, private val preferencesRepository: LoginPreferencesRepository) {
    companion object {
        const val READ_PRIVATE_SCOPE = "user-read-private"
        const val READ_BIRTH_DATE_SCOPE = "user-read-birthdate"
        const val READ_TOP_SCOPE = "user-top-read"

    }

    open fun loginUser(activity: Activity, requestCode: Int) {
        AuthenticationClient.openLoginActivity(activity, requestCode, getAuthenticationRequest())
    }

    private fun getAuthenticationRequest(): AuthenticationRequest {
        return AuthenticationRequest.Builder(context.getString(R.string.spotify_client_id), Type.TOKEN, concatRedirectUri())
                .setShowDialog(false)
                .setScopes(arrayOf(READ_BIRTH_DATE_SCOPE, READ_PRIVATE_SCOPE, READ_TOP_SCOPE))
                .build()
    }

    private fun concatRedirectUri(): String =
            "${context.getString(R.string.com_spotify_sdk_redirect_scheme)}://${context.getString(R.string.com_spotify_sdk_redirect_host)}"


    open fun saveLoginData(accessToken: String, expiresIn: Long): Completable =
            Completable.create { e ->
                try {
                    preferencesRepository.saveLoginData(accessToken, expiresIn)
                    e.onComplete()
                } catch (t: Throwable) {
                    Timber.e(t)
                    e.onError(t)
                }
            }
}