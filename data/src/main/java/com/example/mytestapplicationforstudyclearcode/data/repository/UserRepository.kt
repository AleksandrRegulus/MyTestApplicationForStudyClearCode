package com.example.mytestapplicationforstudyclearcode.data.repository

import com.example.mytestapplicationforstudyclearcode.data.storage.models.User
import com.example.mytestapplicationforstudyclearcode.data.storage.UserStorage
import com.example.mytestapplicationforstudyclearcode.domain.models.SaveUserNameParam
import com.example.mytestapplicationforstudyclearcode.domain.models.UserName
import com.example.mytestapplicationforstudyclearcode.domain.repository.UserRepository

class UserRepositoryImpl(private val userStorage: UserStorage): UserRepository {

     override fun saveName(saveParam: SaveUserNameParam): Boolean {
         val user = mapToStorage(saveParam)
         return userStorage.save(user)
    }

    override fun getName(): UserName {
        val user = userStorage.get()
        return mapToDomain(user = user)
    }

    private fun mapToStorage(saveParam: SaveUserNameParam): User {
        return User(firstName = saveParam.name, lastName = "")
    }
    private fun mapToDomain(user: User): UserName {
        return UserName(firstName = user.firstName, lastName = user.lastName)
    }
}