package com.yggdralisk.koinspotifysample.unit.interactor

import com.yggdralisk.koinspotifysample.data.model.LoginStatus
import com.yggdralisk.koinspotifysample.data.specific.LoginStatusRepository
import com.yggdralisk.koinspotifysample.domain.LoginStatusInteractor
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.BDDMockito.given
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class LoginStatusInteractorTest {
    @Mock
    lateinit var loginStatusRepository: LoginStatusRepository

    private val loginStatusInteractor by lazy {
        LoginStatusInteractor(loginStatusRepository, Schedulers.trampoline(), Schedulers.trampoline())
    }

    @Test
    fun getLoginStatus_shouldReturnNotLoggedIn() {
        given(loginStatusRepository.getLoginStatus())
                .willReturn(Single.just(LoginStatus.LOGGED_OUT))

        loginStatusInteractor.getLoginStatus()
                .test()
                .assertSubscribed()
                .assertResult(LoginStatus.LOGGED_OUT)
    }

    @Test
    fun getLoginStatus_shouldReturnLoggedIn() {
        given(loginStatusRepository.getLoginStatus())
                .willReturn(Single.just(LoginStatus.LOGGED_IN))

        loginStatusInteractor.getLoginStatus()
                .test()
                .assertSubscribed()
                .assertResult(LoginStatus.LOGGED_IN)
    }
}