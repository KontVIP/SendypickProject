package com.kontick.sendypick_cleanarchitecture.di

import com.kontick.sendypick_cleanarchitecture.domain.AuthInteractor
import org.koin.dsl.module

val domainModule = module {

    factory<AuthInteractor> {
        AuthInteractor.Base(get())
    }

}