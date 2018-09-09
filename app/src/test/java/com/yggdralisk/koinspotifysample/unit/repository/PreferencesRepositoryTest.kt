package com.yggdralisk.koinspotifysample.unit.repository

import com.yggdralisk.koinspotifysample.data.common.SharedPreferencesRepository
import junit.framework.TestCase.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.koin.standalone.inject
import org.koin.test.KoinTest
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class PreferencesRepositoryTest : KoinTest {

    private val sharedPreferencesRepository: SharedPreferencesRepository by inject()

    @Test
    fun saveAndReadBool() {
        val testKey = "saveAndReadBool"
        val saveValue = true

        sharedPreferencesRepository.putBoolean(testKey, saveValue)

        assertEquals(saveValue, sharedPreferencesRepository.getBoolean(testKey, false))
    }

    @Test
    fun readDefValBool() {
        val testKey = "readDefValBool"
        val defVal = true

        assertEquals(defVal, sharedPreferencesRepository.getBoolean(testKey, defVal))
    }

}