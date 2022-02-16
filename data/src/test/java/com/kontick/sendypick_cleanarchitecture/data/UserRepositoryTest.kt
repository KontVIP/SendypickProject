package com.kontick.sendypick_cleanarchitecture.data

import com.kontick.sendypick_cleanarchitecture.data.cache.CacheDataSource
import org.junit.Assert
import org.junit.Test
import org.mockito.Mockito
import org.mockito.kotlin.mock


class UserRepositoryTest {

    @Test
    fun `data matching when user empty`() {
        val cacheDataSource = mock<CacheDataSource> ()
        Mockito.`when`(cacheDataSource.fetchUser()).thenReturn(User.Empty())
        val testUserRepository = UserRepository.Base(cacheDataSource)
        val expected = testUserRepository.fetchUser()
        val actual = cacheDataSource.fetchUser()
        Assert.assertEquals(expected, actual)
    }

    @Test
    fun `data matching when user is not empty`() {
        val cacheDataSource = mock<CacheDataSource> ()
        Mockito.`when`(cacheDataSource.fetchUser()).thenReturn(
            User.Base("", "", "", "", "", "")
        )
        val testUserRepository = UserRepository.Base(cacheDataSource)
        val actual = testUserRepository.fetchUser() is User.Base
        Assert.assertEquals(true, actual)
    }

}