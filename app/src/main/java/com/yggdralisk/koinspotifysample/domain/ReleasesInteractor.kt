package com.yggdralisk.koinspotifysample.domain

import com.yggdralisk.koinspotifysample.data.model.ReleaseModel
import com.yggdralisk.koinspotifysample.data.specific.LoginPreferencesRepository
import com.yggdralisk.koinspotifysample.data.specific.ReleasesRepository
import io.reactivex.Scheduler
import io.reactivex.Single

class ReleasesInteractor(private val releasesRepository: ReleasesRepository, private val loginPreferencesRepository: LoginPreferencesRepository,
                         private val subscribeOnScheduler: Scheduler, private val observeOnScheduler: Scheduler) {
    fun getReleases(): Single<List<ReleaseModel>> =
            releasesRepository.fetchReleases(loginPreferencesRepository.getAccessToken())
                    .subscribeOn(subscribeOnScheduler)
                    .observeOn(observeOnScheduler)
                    .map { response ->
                        response.albums.newReleases
                    }
}