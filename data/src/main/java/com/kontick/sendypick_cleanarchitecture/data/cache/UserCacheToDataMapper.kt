package com.kontick.sendypick_cleanarchitecture.data.cache

import com.kontick.sendypick_cleanarchitecture.data.User

interface UserCacheToDataMapper {

    fun map(userRoom: UserRoom): User

    class Base : UserCacheToDataMapper {
        override fun map(userRoom: UserRoom) =
            User.Base(
                userRoom.uid,
                userRoom.name,
                userRoom.phone,
                userRoom.email,
                userRoom.profilePhotoPath,
                userRoom.roomCode
            )
    }

}