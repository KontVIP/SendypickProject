package com.kontick.sendypick_cleanarchitecture.presentation.login

import android.os.Bundle
import com.kontick.sendypick_cleanarchitecture.databinding.ActivityAuthBinding
import com.kontick.sendypick_cleanarchitecture.presentation.core.BaseActivity
import com.kontick.sendypick_cleanarchitecture.presentation.start.StartViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class AuthActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityAuthBinding.inflate(layoutInflater)
        setContentView(binding.root)



    }

}
