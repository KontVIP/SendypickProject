package com.kontick.sendypick_cleanarchitecture.data



interface User {

    fun <T> map(mapper: UserMapper<T>): T

    class Base(
        private val id: String,
        private val name: String,
        private val phone: String,
        private val email: String,
        private val profilePhotoPath: String,
        private val roomCode: String
    ) : User {
        override fun <T> map(mapper: UserMapper<T>): T =
            mapper.map(id, name, phone, email, profilePhotoPath, roomCode)
    }

    class Empty : User {
        override fun <T> map(mapper: UserMapper<T>): T =
            mapper.map("", "", "", "", "", "")
    }

}
