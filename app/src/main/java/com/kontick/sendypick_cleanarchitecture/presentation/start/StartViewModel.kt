package com.kontick.sendypick_cleanarchitecture.presentation.start

import androidx.lifecycle.ViewModel
import com.kontick.sendypick_cleanarchitecture.domain.AuthInteractor

class StartViewModel(
    private val authInteractor: AuthInteractor
) : ViewModel() {

    fun isAuthorized() = authInteractor.isAuthorized()

    fun isUpdateAvailable(currentVersion: Int) : Boolean {
        TODO("Not yet implemented")
    }

}