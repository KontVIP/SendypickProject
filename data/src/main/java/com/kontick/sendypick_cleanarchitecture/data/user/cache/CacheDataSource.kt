package com.kontick.sendypick_cleanarchitecture.data.user.cache

import com.kontick.sendypick_cleanarchitecture.data.user.UserData

interface CacheDataSource {

    fun fetchUser(): UserData
    fun saveUser(userData: UserData)

    class Base(
        private val userDao: UserDao,
        private val userCacheToDataMapper: UserCacheToDataMapper
    ) : CacheDataSource {

        override fun fetchUser() =
            if (userDao.readAllData().value.isNullOrEmpty())
                UserData.Empty()
            else
                userCacheToDataMapper.map(userDao.readAllData().value!![0])

        override fun saveUser(userData: UserData) {
            TODO("Not yet implemented")
        }

    }

}