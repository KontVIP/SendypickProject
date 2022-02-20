package com.kontick.sendypick_cleanarchitecture.data.user.cache

import com.kontick.sendypick_cleanarchitecture.data.user.UserData

interface UserCacheToDataMapper {

    fun map(userRoom: UserRoom): UserData

    class Base : UserCacheToDataMapper {
        override fun map(userRoom: UserRoom) =
            UserData.Base(
                userRoom.uid,
                userRoom.name,
                userRoom.phone,
                userRoom.email,
                userRoom.profilePhotoPath,
                userRoom.roomCode
            )
    }

}