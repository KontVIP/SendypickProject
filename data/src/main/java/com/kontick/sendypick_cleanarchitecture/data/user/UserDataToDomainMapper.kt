package com.kontick.sendypick_cleanarchitecture.data.user

import com.kontick.sendypick_cleanarchitecture.domain.UserDomain
import com.kontick.sendypick_cleanarchitecture.domain.UserMapper

interface UserDataToDomainMapper {

    fun map(userData: UserData): UserDomain

    class Base : UserDataToDomainMapper {
        override fun map(userData: UserData) =
            if (userData is UserData.Empty)
                UserDomain.Empty()
            else
                UserDomain.Base(
                    userData.map(UserMapper.UserId()),
                    userData.map(UserMapper.UserFullName()),
                    userData.map(UserMapper.UserPhone()),
                    userData.map(UserMapper.UserEmail()),
                    userData.map(UserMapper.UserProfilePhotoPath()),
                    userData.map(UserMapper.RoomCode())
                )
    }

}