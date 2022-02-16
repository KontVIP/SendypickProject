package com.kontick.sendypick_cleanarchitecture.data

import com.kontick.sendypick_cleanarchitecture.data.cache.CacheDataSource


interface UserRepository {

    fun fetchUser(): User

    class Base(
        private val cacheDataSource: CacheDataSource
    ) : UserRepository {
        override fun fetchUser() = cacheDataSource.fetchUser()
    }

}

