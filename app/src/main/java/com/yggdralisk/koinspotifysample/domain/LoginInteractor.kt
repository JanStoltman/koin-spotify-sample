package com.yggdralisk.koinspotifysample.domain

import android.app.Activity
import com.yggdralisk.koinspotifysample.data.specific.LoginRepository

class LoginInteractor(private val repository: LoginRepository) {
    /**
     * Opens Spotify LoginActivity which performs authorization.
     * The result of the authorization flow will be received by the
     * {@code contextActivity} in the {@code onActivityResult} callback.
     * The successful result of the authorization flow will contain an access token that can be used
     * to make calls to the Web API and/or to play music with Spotify.
     *
     * @param contextActivity A context activity for the LoginActivity.
     * @param requestCode     Request code for LoginActivity.
     */
    fun openSpotifyLoginActivity(contextActivity: Activity, requestCode: Int) {
        repository.loginUser(contextActivity, requestCode)
    }
}