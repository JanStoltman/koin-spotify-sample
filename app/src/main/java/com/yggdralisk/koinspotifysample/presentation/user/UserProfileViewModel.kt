package com.yggdralisk.koinspotifysample.presentation.user

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.yggdralisk.koinspotifysample.R
import com.yggdralisk.koinspotifysample.data.model.response.UserProfile
import com.yggdralisk.koinspotifysample.domain.UserProfileInteractor
import com.yggdralisk.koinspotifysample.presentation.base.BaseViewModel
import io.reactivex.rxkotlin.addTo

class UserProfileViewModel(private val userProfileInteractor: UserProfileInteractor) : BaseViewModel() {
    private val userProfile = MutableLiveData<UserProfile>()
    private val fetchErrorResId = MutableLiveData<Int?>()

    fun getUserProfile(): LiveData<UserProfile> {
        userProfileInteractor.getUserProfile()
                .subscribe({
                    handleResponse(it)
                }, {
                    handleError()
                }).addTo(subscriptions)

        return userProfile
    }

    private fun handleError() {
        fetchErrorResId.value = R.string.fetch_def_error
    }

    private fun handleResponse(response: UserProfile) {
        fetchErrorResId.value = null
        userProfile.value = response
    }

    fun getFetchErrorResId(): LiveData<Int?> = fetchErrorResId
}