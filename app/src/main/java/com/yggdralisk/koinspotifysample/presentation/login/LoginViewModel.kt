package com.yggdralisk.koinspotifysample.presentation.login

import android.content.Intent
import androidx.lifecycle.ViewModel
import com.yggdralisk.koinspotifysample.domain.LoginInteractor

class LoginViewModel(private val loginInteractor: LoginInteractor) : ViewModel() {
    companion object {
        const val LOGIN_REQUEST_CODE = 1
    }

    fun onLoginButtonClick(contextActivity: LoginActivity) {
        loginInteractor.openSpotifyLoginActivity(contextActivity, LOGIN_REQUEST_CODE)
    }

    /**
     * @return true if result has been handled, false otherwise
     */
    fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?): Boolean =
            if (requestCode == LOGIN_REQUEST_CODE) {
                true
            } else {
                false
            }
}