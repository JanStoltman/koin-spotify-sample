package com.yggdralisk.koinspotifysample.data.specific

import com.yggdralisk.koinspotifysample.data.model.response.NewReleasesResponse
import com.yggdralisk.koinspotifysample.data.remote.ApiService
import io.reactivex.Single

class ReleasesRepository(private val apiService: ApiService) {
    fun fetchReleases(accessToken: String): Single<NewReleasesResponse> = apiService.getNewReleases(accessToken)
}