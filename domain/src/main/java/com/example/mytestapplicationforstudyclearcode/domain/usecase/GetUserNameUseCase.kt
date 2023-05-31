package com.example.mytestapplicationforstudyclearcode.domain.usecase

import com.example.mytestapplicationforstudyclearcode.domain.models.UserName
import com.example.mytestapplicationforstudyclearcode.domain.repository.UserRepository

class GetUserNameUseCase(private val userRepository: UserRepository) {

    fun execute(): UserName {
        return userRepository.getName()
    }
}