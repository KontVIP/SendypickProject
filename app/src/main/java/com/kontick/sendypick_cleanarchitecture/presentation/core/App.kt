package com.kontick.sendypick_cleanarchitecture.presentation.core

import android.app.Application
import com.kontick.sendypick_cleanarchitecture.data.User
import com.kontick.sendypick_cleanarchitecture.data.cache.UserCacheToDataMapper
import com.kontick.sendypick_cleanarchitecture.data.UserRepository
import com.kontick.sendypick_cleanarchitecture.data.cache.CacheDataSource
import com.kontick.sendypick_cleanarchitecture.data.cache.UserDatabase
import com.kontick.sendypick_cleanarchitecture.di.appModule
import com.kontick.sendypick_cleanarchitecture.di.dataModule
import com.kontick.sendypick_cleanarchitecture.di.domainModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        val userDao = UserDatabase.getDatabase(this).userDao()
        val cacheDataSource = CacheDataSource.Base(userDao, UserCacheToDataMapper.Base())

        val userRepository = UserRepository.Base(cacheDataSource)

        //then create interactor here and send userRepository

        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@App)
            modules(listOf(appModule, domainModule, dataModule))
        }

    }
}