package com.yggdralisk.koinspotifysample.presentation.login

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.yggdralisk.koinspotifysample.R
import com.yggdralisk.koinspotifysample.data.model.LoginStatus
import com.yggdralisk.koinspotifysample.presentation.releases.ReleasesActivity
import kotlinx.android.synthetic.main.activity_login.*
import org.koin.androidx.viewmodel.ext.android.viewModel


class LoginActivity : AppCompatActivity() {
    private val viewModel by viewModel<LoginViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        observeViewModel()
        loginButton.setOnClickListener { viewModel.onLoginButtonClick(this) }
    }

    private fun observeViewModel() {
        viewModel.getLoginError().observe({ this.lifecycle }, {
            loginErrorView.text = if (it != null) getString(it) else ""
        })

        viewModel.getLoginStatus().observe({ this.lifecycle }, {
            if (it == LoginStatus.LOGGED_IN) startReleasesActivity()
        })
    }

    private fun startReleasesActivity() {
        startActivity(Intent(this, ReleasesActivity::class.java))
        this.finish()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (viewModel.onActivityResult(requestCode, resultCode, data)) {
            return
        } else {
            super.onActivityResult(requestCode, resultCode, data)
        }
    }
}
