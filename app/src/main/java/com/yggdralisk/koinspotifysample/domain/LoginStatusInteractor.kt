package com.yggdralisk.koinspotifysample.domain

import com.yggdralisk.koinspotifysample.data.model.LoginStatus
import com.yggdralisk.koinspotifysample.data.specific.LoginStatusRepository
import io.reactivex.Scheduler
import io.reactivex.Single

open class LoginStatusInteractor(private val loginStatusRepository: LoginStatusRepository,
                                 private val subscribeOnScheduler: Scheduler, private val observeOnScheduler: Scheduler) {
    open fun getLoginStatus(): Single<LoginStatus> =
            loginStatusRepository.getLoginStatus()
                    .subscribeOn(subscribeOnScheduler)
                    .observeOn(observeOnScheduler)
}