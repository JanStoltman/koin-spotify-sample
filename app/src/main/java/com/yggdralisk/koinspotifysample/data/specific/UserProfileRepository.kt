package com.yggdralisk.koinspotifysample.data.specific

import com.yggdralisk.koinspotifysample.data.model.response.UserProfile
import com.yggdralisk.koinspotifysample.data.remote.ApiService
import io.reactivex.Single

class UserProfileRepository(private val apiService: ApiService) {
    fun fetchUserProfile(accessToken: String): Single<UserProfile> = apiService.getUserProfile("Bearer $accessToken")
}