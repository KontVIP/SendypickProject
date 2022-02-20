package com.kontick.sendypick_cleanarchitecture.data.user

import com.kontick.sendypick_cleanarchitecture.data.user.cache.CacheDataSource
import com.kontick.sendypick_cleanarchitecture.domain.UserRepository


class UserDataRepository(
    private val cacheDataSource: CacheDataSource,
    private val userDataToDomainMapper: UserDataToDomainMapper
) : UserRepository {
    override fun fetchUser() = userDataToDomainMapper.map(cacheDataSource.fetchUser())
}


