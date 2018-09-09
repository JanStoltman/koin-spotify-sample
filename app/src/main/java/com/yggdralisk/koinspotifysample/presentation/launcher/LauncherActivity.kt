package com.yggdralisk.koinspotifysample.presentation.launcher

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class LauncherActivity : AppCompatActivity() {

    private val viewModel by viewModel<LauncherViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        fetchIntentAndStart()
    }

    private fun fetchIntentAndStart() {
        viewModel.getActivityToStart().observe({ this.lifecycle }, {
            startActivity(Intent(this, it))
            this.finish()
        })
    }
}
