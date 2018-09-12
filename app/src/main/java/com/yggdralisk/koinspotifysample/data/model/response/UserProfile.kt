package com.yggdralisk.koinspotifysample.data.model.response

import com.yggdralisk.koinspotifysample.data.model.ExternalUrls
import com.yggdralisk.koinspotifysample.data.model.Followers
import com.yggdralisk.koinspotifysample.data.model.Image

data class UserProfile(
        val birthdate: String?,
        val country: String?,
        val display_name: String?,
        val email: String?,
        val external_urls: ExternalUrls,
        val followers: Followers,
        val href: String?,
        val id: String?,
        val images: List<Image>,
        val product: String?,
        val type: String?,
        val uri: String?
)