package com.kontick.sendypick_cleanarchitecture.di


import com.kontick.sendypick_cleanarchitecture.presentation.start.StartViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module



val appModule = module {

    viewModel<StartViewModel> {
        StartViewModel(
            authInteractor = get()
        )
    }

}