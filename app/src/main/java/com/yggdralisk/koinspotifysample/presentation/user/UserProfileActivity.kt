package com.yggdralisk.koinspotifysample.presentation.user

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.yggdralisk.koinspotifysample.R
import com.yggdralisk.koinspotifysample.data.model.response.UserProfile
import kotlinx.android.synthetic.main.activity_user_profile.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class UserProfileActivity : AppCompatActivity() {
    private val viewModel by viewModel<UserProfileViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_profile)
        observeViewModel()
    }

    private fun observeViewModel() {
        viewModel.getUserProfile().observe({ this.lifecycle }, {
            insertProfileIntoLayout(it)
        })
    }

    private fun insertProfileIntoLayout(profile: UserProfile) {
        userNameTextView.text = profile.display_name ?: profile.id
        userBirthdayTextView.text = profile.birthdate
        userEmailTextView.text = profile.email
        Glide.with(this).load("https://www.countryflags.io/${profile.country?.toLowerCase()}/flat/64.png").into(userFlagImage)
    }
}
