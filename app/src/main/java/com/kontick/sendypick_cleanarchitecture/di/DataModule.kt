package com.kontick.sendypick_cleanarchitecture.di

import com.kontick.sendypick_cleanarchitecture.data.user.UserDataRepository
import com.kontick.sendypick_cleanarchitecture.data.user.UserDataToDomainMapper
import com.kontick.sendypick_cleanarchitecture.data.user.cache.CacheDataSource
import com.kontick.sendypick_cleanarchitecture.data.user.cache.UserCacheToDataMapper
import com.kontick.sendypick_cleanarchitecture.data.user.cache.UserDao
import com.kontick.sendypick_cleanarchitecture.data.user.cache.UserDatabase
import com.kontick.sendypick_cleanarchitecture.domain.UserRepository
import org.koin.dsl.module

val dataModule = module {

    single<UserDao> {
        UserDatabase.getDatabase(get()).userDao()
    }

    single<CacheDataSource> {
        CacheDataSource.Base(get(), UserCacheToDataMapper.Base())
    }

    single<UserRepository> {
        UserDataRepository(get(), UserDataToDomainMapper.Base())
    }

}