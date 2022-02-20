package com.kontick.sendypick_cleanarchitecture.domain

interface AuthInteractor {

    fun isAuthorized() : Boolean

    class Base(
        private val userRepository : UserRepository
    ) : AuthInteractor {

        override fun isAuthorized() = userRepository.fetchUser() !is UserDomain.Empty

    }

}