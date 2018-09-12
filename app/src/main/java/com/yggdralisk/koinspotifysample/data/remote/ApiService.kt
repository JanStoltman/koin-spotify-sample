package com.yggdralisk.koinspotifysample.data.remote

import com.yggdralisk.koinspotifysample.data.model.response.NewReleasesResponse
import com.yggdralisk.koinspotifysample.data.model.response.UserProfile
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Header

interface ApiService {
    companion object {
        const val BASE_URL = "https://api.spotify.com"
    }

    @GET("/v1/browse/new-releases")
    fun getNewReleases(@Header("Authorization") accessToken: String): Single<NewReleasesResponse>

    @GET("/v1/me")
    fun getUserProfile(@Header("Authorization") accessToken: String): Single<UserProfile>
}