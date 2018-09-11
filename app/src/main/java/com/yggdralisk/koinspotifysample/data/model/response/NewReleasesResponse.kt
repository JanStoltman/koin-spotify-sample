package com.yggdralisk.koinspotifysample.data.model.response

import com.google.gson.annotations.SerializedName
import com.yggdralisk.koinspotifysample.data.model.Albums

data class NewReleasesResponse(
        @SerializedName("albums") val albums: Albums
)