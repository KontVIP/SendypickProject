package com.kontick.sendypick_cleanarchitecture.data

import com.kontick.sendypick_cleanarchitecture.data.user.UserData
import com.kontick.sendypick_cleanarchitecture.data.user.UserDataRepository
import com.kontick.sendypick_cleanarchitecture.data.user.UserDataToDomainMapper
import com.kontick.sendypick_cleanarchitecture.data.user.cache.CacheDataSource
import com.kontick.sendypick_cleanarchitecture.data.user.cache.UserCacheToDataMapper
import com.kontick.sendypick_cleanarchitecture.data.user.cache.UserRoom
import com.kontick.sendypick_cleanarchitecture.domain.UserDomain
import com.kontick.sendypick_cleanarchitecture.domain.UserMapper
import org.junit.Assert
import org.junit.Test
import org.mockito.Mockito
import org.mockito.kotlin.mock


class UserDataRepositoryTest {

    @Test
    fun `data matching when user is empty`() {
        val cacheDataSource = mock<CacheDataSource>()
        Mockito.`when`(cacheDataSource.fetchUser()).thenReturn(UserData.Empty())
        val testUserRepository = UserDataRepository(cacheDataSource, UserDataToDomainMapper.Base())
        val expected = testUserRepository.fetchUser()
        val actual = UserDataToDomainMapper.Base().map(cacheDataSource.fetchUser())
        Assert.assertEquals(expected, actual)
    }

    @Test
    fun `data matching when user is not empty`() {
        val cacheDataSource = mock<CacheDataSource>()
        Mockito.`when`(cacheDataSource.fetchUser()).thenReturn(
            UserData.Base("", "", "", "", "", "")
        )
        val testUserRepository = UserDataRepository(cacheDataSource, UserDataToDomainMapper.Base())
        val actual = testUserRepository.fetchUser() is UserDomain.Base
        Assert.assertEquals(true, actual)
    }

    @Test
    fun `data matching in dao and repository`() {
        val testUserRoom = UserRoom(
            1,
            "1",
            "test@mail.com",
            "test phone",
            "test name",
            "test code",
            "test path",
            0
        )
        val cacheDataSourceTest = CacheDataSourceTest(testUserRoom, UserCacheToDataMapper.Base())
        val userRepositoryTest = UserDataRepository(cacheDataSourceTest, UserDataToDomainMapper.Base())
        val expected = testUserRoom.email
        val actual = userRepositoryTest.fetchUser().map(UserMapper.UserEmail())

        Assert.assertEquals(expected, actual)
    }


}

class CacheDataSourceTest(
    private val testUserRoom: UserRoom,
    private val userCacheToDataMapper: UserCacheToDataMapper
) : CacheDataSource {

    override fun fetchUser() = userCacheToDataMapper.map(testUserRoom)

    override fun saveUser(userData: UserData) {
        TODO("Not yet implemented")
    }
}