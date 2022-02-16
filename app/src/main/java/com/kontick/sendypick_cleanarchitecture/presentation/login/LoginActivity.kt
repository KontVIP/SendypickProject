package com.kontick.sendypick_cleanarchitecture.presentation.login

import android.content.Intent
import android.os.Bundle
import com.kontick.sendypick_cleanarchitecture.databinding.ActivityLoginBinding
import com.kontick.sendypick_cleanarchitecture.presentation.core.BaseActivity
import com.kontick.sendypick_cleanarchitecture.presentation.main.MainActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginActivity : BaseActivity() {

    private val viewModel by viewModel<LoginViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)



//        val viewModel = viewModel(LoginViewModel::class.java, this)
//        viewModel.observe(this) {
//            if (it is LoginUi.Success) {
//                startActivity(Intent(this, MainActivity::class.java))
//                finish()
//            } else
//                it.map(binding.errorTextView, binding.progressBar, binding.loginButton)
//        }
//        binding.loginButton.setOnClickListener { viewModel.login(LoginWrapper.Base(this)) }
//        viewModel.init()
    }

}
