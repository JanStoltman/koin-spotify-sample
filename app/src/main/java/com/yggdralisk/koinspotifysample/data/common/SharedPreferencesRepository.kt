package com.yggdralisk.koinspotifysample.data.common

import android.content.SharedPreferences

open class SharedPreferencesRepository(private val sharedPreferences: SharedPreferences) {

    open fun getBoolean(name: String, defVal: Boolean): Boolean = sharedPreferences.getBoolean(name, defVal)

    open fun putBoolean(name: String, value: Boolean) = sharedPreferences.edit().putBoolean(name, value).apply()

}