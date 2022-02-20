package com.kontick.sendypick_cleanarchitecture.data.user

import com.kontick.sendypick_cleanarchitecture.domain.UserMapper


interface UserData {

    fun <T> map(mapper: UserMapper<T>): T

    data class Base(
        private val id: String,
        private val name: String,
        private val phone: String,
        private val email: String,
        private val profilePhotoPath: String,
        private val roomCode: String
    ) : UserData {
        override fun <T> map(mapper: UserMapper<T>) =
            mapper.map(id, name, phone, email, profilePhotoPath, roomCode)
    }

    class Empty : UserData {
        override fun <T> map(mapper: UserMapper<T>) =
            mapper.map("", "", "", "", "", "")
    }

}

