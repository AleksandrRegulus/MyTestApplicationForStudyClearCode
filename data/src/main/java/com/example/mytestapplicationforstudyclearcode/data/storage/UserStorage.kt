package com.example.mytestapplicationforstudyclearcode.data.storage

import com.example.mytestapplicationforstudyclearcode.data.storage.models.User

interface UserStorage {

    fun save(user: User): Boolean

    fun get(): User
}