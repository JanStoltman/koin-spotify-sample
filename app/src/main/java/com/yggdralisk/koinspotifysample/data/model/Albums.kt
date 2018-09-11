package com.yggdralisk.koinspotifysample.data.model

import com.google.gson.annotations.SerializedName

data class Albums(
        @SerializedName("items") val newReleases: List<ReleaseModel>,
        @SerializedName("href") val href: String,
        @SerializedName("limit") val limitOfReleases: Int,
        @SerializedName("next") val nextPage: String?,
        @SerializedName("offset") val offsetOfReleases: Int,
        @SerializedName("previous") val previousPage: String?,
        @SerializedName("total") val totalReleases: Int
)