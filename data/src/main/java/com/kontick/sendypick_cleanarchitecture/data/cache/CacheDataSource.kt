package com.kontick.sendypick_cleanarchitecture.data.cache

import com.kontick.sendypick_cleanarchitecture.data.User

interface CacheDataSource {

    fun fetchUser(): User
    fun saveUser(user: User)

    class Base(
        private val userDao: UserDao,
        private val userCacheToDataMapper: UserCacheToDataMapper
    ) : CacheDataSource {

        override fun fetchUser() =
            if (userDao.readAllData().value.isNullOrEmpty())
                User.Empty()
            else
                userCacheToDataMapper.map(userDao.readAllData().value!![0])

        override fun saveUser(user: User) {
            TODO("Not yet implemented")
        }

    }

}