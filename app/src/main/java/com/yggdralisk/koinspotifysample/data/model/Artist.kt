package com.yggdralisk.koinspotifysample.data.model

data class Artist(
        val external_urls: ExternalUrls,
        val href: String,
        val id: String,
        val name: String,
        val type: String,
        val uri: String
)