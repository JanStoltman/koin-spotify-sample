package com.yggdralisk.koinspotifysample.domain

import com.yggdralisk.koinspotifysample.data.model.response.UserProfile
import com.yggdralisk.koinspotifysample.data.specific.LoginPreferencesRepository
import com.yggdralisk.koinspotifysample.data.specific.UserProfileRepository
import io.reactivex.Scheduler
import io.reactivex.Single

class UserProfileInteractor(private val userProfileRepository: UserProfileRepository, private val loginPreferencesRepository: LoginPreferencesRepository,
                            private val subscribeOnScheduler: Scheduler, private val observeOnScheduler: Scheduler) {
    fun getUserProfile(): Single<UserProfile> =
            userProfileRepository.fetchUserProfile(loginPreferencesRepository.getAccessToken())
                    .subscribeOn(subscribeOnScheduler)
                    .observeOn(observeOnScheduler)
}