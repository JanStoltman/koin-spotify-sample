package com.yggdralisk.koinspotifysample.presentation.login

import android.content.Intent
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.spotify.sdk.android.authentication.AuthenticationClient
import com.spotify.sdk.android.authentication.AuthenticationResponse
import com.yggdralisk.koinspotifysample.R
import com.yggdralisk.koinspotifysample.data.model.LoginStatus
import com.yggdralisk.koinspotifysample.domain.LoginInteractor
import com.yggdralisk.koinspotifysample.presentation.base.BaseViewModel
import io.reactivex.rxkotlin.addTo

class LoginViewModel(private val loginInteractor: LoginInteractor) : BaseViewModel() {
    companion object {
        const val LOGIN_REQUEST_CODE = 1
    }

    private val loginErrorResId = MutableLiveData<Int?>()
    private val loginStatus = MutableLiveData<LoginStatus>()

    fun onLoginButtonClick(contextActivity: LoginActivity) {
        loginErrorResId.value = null
        loginInteractor.openSpotifyLoginActivity(contextActivity, LOGIN_REQUEST_CODE)
    }

    fun getLoginErrorResId(): LiveData<Int?> {
        return loginErrorResId
    }

    fun getLoginStatus(): LiveData<LoginStatus> {
        return loginStatus
    }

    /**
     * @return true if result has been handled, false otherwise
     */
    fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?): Boolean =
            if (requestCode == LOGIN_REQUEST_CODE) {
                val response = AuthenticationClient.getResponse(resultCode, data)
                when (response.type) {
                    AuthenticationResponse.Type.TOKEN -> {
                        handleResponse(response)
                    }
                    // Let's handle error and cancellation in the same branch for the sake of simplicity
                    else -> {
                        handleError()
                    }
                }
                true
            } else {
                false
            }

    private fun handleResponse(response: AuthenticationResponse) {
        loginInteractor.saveLoginData(response.accessToken, response.expiresIn)
                .subscribe({ loginStatus.value = LoginStatus.LOGGED_IN }, { _ -> handleError() })
                .addTo(subscriptions)
    }

    private fun handleError() {
        loginErrorResId.value = R.string.login_def_error
    }
}