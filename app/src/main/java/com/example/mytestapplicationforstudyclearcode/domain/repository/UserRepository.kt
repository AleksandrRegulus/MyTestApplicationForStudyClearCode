package com.example.mytestapplicationforstudyclearcode.domain.repository

import com.example.mytestapplicationforstudyclearcode.domain.models.SaveUserNameParam
import com.example.mytestapplicationforstudyclearcode.domain.models.UserName

interface UserRepository {

    fun saveName(saveParam: SaveUserNameParam): Boolean

    fun getName(): UserName
}