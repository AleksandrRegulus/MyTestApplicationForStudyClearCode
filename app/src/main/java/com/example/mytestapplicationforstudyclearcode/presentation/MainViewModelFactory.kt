package com.example.mytestapplicationforstudyclearcode.presentation

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mytestapplicationforstudyclearcode.data.repository.UserRepositoryImpl
import com.example.mytestapplicationforstudyclearcode.data.storage.sharedprefs.SharedPrefUserStorage
import com.example.mytestapplicationforstudyclearcode.domain.usecase.GetUserNameUseCase
import com.example.mytestapplicationforstudyclearcode.domain.usecase.SaveUserNameUseCase

class MainViewModelFactory(context: Context): ViewModelProvider.Factory{

    private val userRepository by lazy(LazyThreadSafetyMode.NONE) {
        UserRepositoryImpl(userStorage = SharedPrefUserStorage(context = context))
    }
    private val getUserNameUseCase by lazy(LazyThreadSafetyMode.NONE) {
        GetUserNameUseCase(userRepository = userRepository)
    }
    private val saveUserNameUseCase by lazy(LazyThreadSafetyMode.NONE) {
        SaveUserNameUseCase(userRepository = userRepository)
    }

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(
            getUserNameUseCase = getUserNameUseCase,
            saveUserNameUseCase = saveUserNameUseCase
        ) as T
    }
}