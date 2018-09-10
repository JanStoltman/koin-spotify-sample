package com.yggdralisk.koinspotifysample.data.model.response

import com.google.gson.annotations.SerializedName
import com.yggdralisk.koinspotifysample.data.model.ReleaseModel

data class NewReleasesResponse(
        @SerializedName("albums") val newReleases: List<ReleaseModel>,
        @SerializedName("href") val href: String,
        @SerializedName("limit") val limitOfReleases: Int,
        @SerializedName("next") val nextPage: String?,
        @SerializedName("offset") val offsetOfReleases: Int,
        @SerializedName("previous") val previousPage: String?,
        @SerializedName("total") val totalReleases: Int
)