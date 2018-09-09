package com.yggdralisk.koinspotifysample.unit.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.yggdralisk.koinspotifysample.data.model.LoginStatus
import com.yggdralisk.koinspotifysample.domain.LoginStatusInteractor
import com.yggdralisk.koinspotifysample.presentation.launcher.LauncherViewModel
import com.yggdralisk.koinspotifysample.presentation.login.LoginActivity
import com.yggdralisk.koinspotifysample.presentation.releases.ReleasesActivity
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
    fun getActivityToStart_shouldReturnLoginActivity() {
        doReturn(Single.just(LoginStatus.LOGGED_OUT)).`when`(mockLoginStatusInteractor).getLoginStatus()

        assertEquals(LoginActivity::class.java, launcherViewModel.getActivityToStart().value)
        verify(mockLoginStatusInteractor, times(1)).getLoginStatus()
    }

    @Test
    fun getActivityToStart_shouldReturnReleasesActivity() {
        doReturn(Single.just(LoginStatus.LOGGED_IN)).`when`(mockLoginStatusInteractor).getLoginStatus()

        assertEquals(ReleasesActivity::class.java, launcherViewModel.getActivityToStart().value)
        verify(mockLoginStatusInteractor, times(1)).getLoginStatus()
    }

}