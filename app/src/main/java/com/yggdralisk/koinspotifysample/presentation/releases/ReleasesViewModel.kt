package com.yggdralisk.koinspotifysample.presentation.releases

import android.app.Activity
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.yggdralisk.koinspotifysample.R
import com.yggdralisk.koinspotifysample.data.model.ReleaseModel
import com.yggdralisk.koinspotifysample.domain.ReleasesInteractor
import com.yggdralisk.koinspotifysample.presentation.base.BaseViewModel
import com.yggdralisk.koinspotifysample.presentation.release.ReleaseDetailsActivity
import com.yggdralisk.koinspotifysample.presentation.user.UserProfileActivity
import com.yggdralisk.koinspotifysample.util.common.SingleLiveEvent
import io.reactivex.rxkotlin.addTo

class ReleasesViewModel(private val releasesInteractor: ReleasesInteractor) : BaseViewModel() {
    private val newReleases = MutableLiveData<List<ReleaseModel>>()
    private val fetchErrorResId = MutableLiveData<Int?>()
    private val classToLaunch = SingleLiveEvent<Class<out Activity>>()
    private val chosenRelease = MutableLiveData<ReleaseModel>()

    fun getNewReleases(): LiveData<List<ReleaseModel>> {
        releasesInteractor.getReleases().subscribe({
            handleResponse(it)
        }, {
            handleError()
        }).addTo(subscriptions)
        return newReleases
    }

    private fun handleResponse(response: List<ReleaseModel>) {
        fetchErrorResId.value = null
        newReleases.value = response
    }

    private fun handleError() {
        fetchErrorResId.value = R.string.fetch_def_error
    }

    fun getFetchErrorResId(): LiveData<Int?> = fetchErrorResId

    fun getClassToLaunch(): SingleLiveEvent<Class<out Activity>> = classToLaunch

    fun getChosenRelease(): LiveData<ReleaseModel> = chosenRelease

    fun onUserProfileButtonClick() {
        classToLaunch.value = UserProfileActivity::class.java
    }

    fun onReleaseRowClick(release: ReleaseModel) {
        chosenRelease.value = release
        classToLaunch.value = ReleaseDetailsActivity::class.java
    }
}