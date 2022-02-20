package com.kontick.sendypick_cleanarchitecture.domain


interface UserMapper<T> {

    fun map(
        id: String,
        name: String,
        phone: String,
        email: String,
        profilePhotoPath: String,
        roomCode: String
    ): T

    class UserId : UserMapper<String> {
        override fun map(
            id: String,
            name: String,
            phone: String,
            email: String,
            profilePhotoPath: String,
            roomCode: String
        ) = id
    }

    class UserFullName : UserMapper<String> {
        override fun map(
            id: String,
            name: String,
            phone: String,
            email: String,
            profilePhotoPath: String,
            roomCode: String
        ) = name
    }

    class UserPhone : UserMapper<String> {
        override fun map(
            id: String,
            name: String,
            phone: String,
            email: String,
            profilePhotoPath: String,
            roomCode: String
        ) = phone
    }

    class UserEmail : UserMapper<String> {
        override fun map(
            id: String,
            name: String,
            phone: String,
            email: String,
            profilePhotoPath: String,
            roomCode: String
        ) = email
    }

    class UserProfilePhotoPath : UserMapper<String> {
        override fun map(
            id: String,
            name: String,
            phone: String,
            email: String,
            profilePhotoPath: String,
            roomCode: String
        ) = profilePhotoPath
    }

    class RoomCode : UserMapper<String> {
        override fun map(
            id: String,
            name: String,
            phone: String,
            email: String,
            profilePhotoPath: String,
            roomCode: String
        ) = roomCode
    }

}