package com.yggdralisk.koinspotifysample.presentation.releases

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.yggdralisk.koinspotifysample.R
import com.yggdralisk.koinspotifysample.data.model.ReleaseModel
import com.yggdralisk.koinspotifysample.domain.ReleasesInteractor
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo

class ReleasesViewModel(private val releasesInteractor: ReleasesInteractor) : ViewModel() {
    private val subscriptions = CompositeDisposable()
    private val newReleases = MutableLiveData<List<ReleaseModel>>()
    private val fetchErrorResId = MutableLiveData<Int?>()

    fun getNewReleases(): LiveData<List<ReleaseModel>> {
        releasesInteractor.getReleases().subscribe({
            handleResponse(it)
        }, {
            handleError()
        }).addTo(subscriptions)
        return newReleases
    }

    fun handleError() {
        fetchErrorResId.value = R.string.fetch_def_error
    }

    private fun handleResponse(response: List<ReleaseModel>) {
        fetchErrorResId.value = null
        newReleases.value = response
    }

    fun getFetchErrorResId(): LiveData<Int?> {
        return fetchErrorResId
    }

    override fun onCleared() {
        super.onCleared()
        subscriptions.clear()
    }
}