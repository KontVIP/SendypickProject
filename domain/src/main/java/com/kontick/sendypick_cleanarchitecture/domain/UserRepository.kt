package com.kontick.sendypick_cleanarchitecture.domain

interface UserRepository {

    fun fetchUser() : UserDomain

}