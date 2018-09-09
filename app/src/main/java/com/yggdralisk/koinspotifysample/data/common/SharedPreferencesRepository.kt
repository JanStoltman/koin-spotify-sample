package com.yggdralisk.koinspotifysample.data.common

import android.content.SharedPreferences

open class SharedPreferencesRepository(private val sharedPreferences: SharedPreferences) {

    open fun getBoolean(name: String, defVal: Boolean): Boolean = sharedPreferences.getBoolean(name, defVal)

    open fun putBoolean(name: String, value: Boolean) = sharedPreferences.edit().putBoolean(name, value).apply()

    open fun getString(name: String, defVal: String): String = sharedPreferences.getString(name, defVal)

    open fun putString(name: String, value: String) = sharedPreferences.edit().putString(name, value).apply()

    open fun getLong(name: String, defVal: Long): Long = sharedPreferences.getLong(name, defVal)

    open fun putLong(name: String, value: Long) = sharedPreferences.edit().putLong(name, value).apply()

}