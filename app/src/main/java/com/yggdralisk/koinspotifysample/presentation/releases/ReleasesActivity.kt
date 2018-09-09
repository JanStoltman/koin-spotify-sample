package com.yggdralisk.koinspotifysample.presentation.releases

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.yggdralisk.koinspotifysample.R
import com.yggdralisk.koinspotifysample.presentation.login.LoginViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class ReleasesActivity : AppCompatActivity() {
    private val viewModel by viewModel<LoginViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_releases)
    }
}
