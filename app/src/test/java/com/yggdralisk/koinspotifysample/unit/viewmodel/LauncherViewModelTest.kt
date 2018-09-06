package com.yggdralisk.koinspotifysample.unit.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.yggdralisk.koinspotifysample.data.model.LoginStatus
import com.yggdralisk.koinspotifysample.domain.LoginStatusInteractor
import com.yggdralisk.koinspotifysample.presentation.launcher.LauncherViewModel
import com.yggdralisk.koinspotifysample.unit.utils.RxImmediateSchedulerRule
import io.reactivex.Single
import junit.framework.TestCase.assertEquals
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.BDDMockito.doReturn
import org.mockito.Mock
import org.mockito.Mockito.times
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner


@RunWith(MockitoJUnitRunner::class)
class LauncherViewModelTest {
    @Rule
    @JvmField
    var testSchedulerRule = RxImmediateSchedulerRule()
    @Rule
    @JvmField
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    lateinit var mockLoginStatusInteractor: LoginStatusInteractor

    private val launcherViewModel by lazy {
        LauncherViewModel(mockLoginStatusInteractor)
    }

    @Test
    fun getLoginStatus_shouldReturnNotLoggedIn() {
        doReturn(Single.just(LoginStatus.LOGGED_OUT)).`when`(mockLoginStatusInteractor).getLoginStatus()

        assertEquals(LoginStatus.LOGGED_OUT, launcherViewModel.getLoginStatus().value)
        verify(mockLoginStatusInteractor, times(1)).getLoginStatus()
    }

    @Test
    fun getLoginStatus_shouldReturnLoggedIn() {
        doReturn(Single.just(LoginStatus.LOGGED_IN)).`when`(mockLoginStatusInteractor).getLoginStatus()

        assertEquals(LoginStatus.LOGGED_IN, launcherViewModel.getLoginStatus().value)
        verify(mockLoginStatusInteractor, times(1)).getLoginStatus()
    }

}