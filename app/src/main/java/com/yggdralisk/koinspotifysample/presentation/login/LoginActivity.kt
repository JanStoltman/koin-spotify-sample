package com.yggdralisk.koinspotifysample.presentation.login

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.yggdralisk.koinspotifysample.R
import kotlinx.android.synthetic.main.activity_login.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginActivity : AppCompatActivity() {
    private val viewModel by viewModel<LoginViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        loginButton.setOnClickListener { viewModel.onLoginButtonClick(this) }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (viewModel.onActivityResult(requestCode, resultCode, data)) {
            return
        } else {
            super.onActivityResult(requestCode, resultCode, data)
        }
    }
}
