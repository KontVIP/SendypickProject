package com.kontick.sendypick_cleanarchitecture.di

import com.kontick.sendypick_cleanarchitecture.presentation.login.LoginViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    viewModel<LoginViewModel>{
        LoginViewModel(
            //put use cases
        )
    }

}