package com.yggdralisk.koinspotifysample.unit.repository

import com.yggdralisk.koinspotifysample.data.common.SharedPreferencesRepository
import com.yggdralisk.koinspotifysample.data.model.LoginStatus
import com.yggdralisk.koinspotifysample.data.specific.LoginStatusRepository
import com.yggdralisk.koinspotifysample.data.specific.LoginStatusRepository.Companion.LOGIN_STATUS_PREF
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.doReturn
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class LoginRepositoryTest {
    @Mock
    lateinit var sharedPreferencesRepository: SharedPreferencesRepository

    private val loginStatusRepository by lazy {
        LoginStatusRepository(sharedPreferencesRepository)
    }

    @Test
    fun getLoginStatus_shouldReturnNotLoggedIn() {
        doReturn(false).`when`(sharedPreferencesRepository).getBoolean(LOGIN_STATUS_PREF, false)

        loginStatusRepository.getLoginStatus()
                .test()
                .assertSubscribed()
                .assertResult(LoginStatus.LOGGED_OUT)
    }

    @Test
    fun getLoginStatus_shouldReturnLoggedIn() {
        doReturn(true).`when`(sharedPreferencesRepository).getBoolean(LOGIN_STATUS_PREF, false)

        loginStatusRepository.getLoginStatus()
                .test()
                .assertSubscribed()
                .assertResult(LoginStatus.LOGGED_IN)
    }
}