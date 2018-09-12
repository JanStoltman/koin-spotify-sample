package com.yggdralisk.koinspotifysample.presentation.release

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.yggdralisk.koinspotifysample.data.model.ReleaseModel
import com.yggdralisk.koinspotifysample.presentation.base.BaseViewModel

class ReleaseDetailsViewModel : BaseViewModel() {
    private val releaseDetails = MutableLiveData<ReleaseModel>()

    fun getRelease(): LiveData<ReleaseModel> = releaseDetails

    fun setRelease(release: ReleaseModel) {
        releaseDetails.value = release
    }
}