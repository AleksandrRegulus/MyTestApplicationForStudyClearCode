package com.example.mytestapplicationforstudyclearcode.domain.usecase

import com.example.mytestapplicationforstudyclearcode.domain.models.SaveUserNameParam
import com.example.mytestapplicationforstudyclearcode.domain.repository.UserRepository

class SaveUserNameUseCase(private val userRepository: UserRepository) {

    fun execute(param: SaveUserNameParam): Boolean {
        val result = userRepository.saveName(saveParam = param)
        return result
    }

}