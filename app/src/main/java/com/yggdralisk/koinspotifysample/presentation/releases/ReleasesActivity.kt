package com.yggdralisk.koinspotifysample.presentation.releases

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.yggdralisk.koinspotifysample.R
import org.koin.androidx.viewmodel.ext.android.viewModel

class ReleasesActivity : AppCompatActivity() {
    private val viewModel by viewModel<ReleasesViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_releases)
        observeViewModel()
    }

    private fun observeViewModel() {
        viewModel.getNewReleases().observe({ this.lifecycle }, {

        })

        viewModel.getFetchErrorResId().observe({ this.lifecycle }, {

        })
    }
}
