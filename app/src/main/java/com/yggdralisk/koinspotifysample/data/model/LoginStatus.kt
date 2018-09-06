package com.yggdralisk.koinspotifysample.data.model

enum class LoginStatus {
    LOGGED_OUT,
    LOGGED_IN;

    companion object {
        fun fromBoolean(isLoggedIn: Boolean): LoginStatus =
                if (isLoggedIn) {
                    LOGGED_IN
                } else {
                    LOGGED_OUT
                }
    }
}