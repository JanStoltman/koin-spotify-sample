package com.yggdralisk.koinspotifysample.presentation.releases

import com.yggdralisk.koinspotifysample.data.model.ReleaseModel

interface ReleasesRowClickReceiver {
    fun onReleaseRowClick(release: ReleaseModel)
}