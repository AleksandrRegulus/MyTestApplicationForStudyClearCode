package com.example.mytestapplicationforstudyclearcode.presentation

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mytestapplicationforstudyclearcode.R
import com.example.mytestapplicationforstudyclearcode.data.repository.UserRepositoryImpl
import com.example.mytestapplicationforstudyclearcode.data.storage.sharedprefs.SharedPrefUserStorage
import com.example.mytestapplicationforstudyclearcode.domain.models.SaveUserNameParam
import com.example.mytestapplicationforstudyclearcode.domain.usecase.GetUserNameUseCase
import com.example.mytestapplicationforstudyclearcode.domain.usecase.SaveUserNameUseCase

class MainActivity : AppCompatActivity() {

    private val userRepository by lazy(LazyThreadSafetyMode.NONE) {
        UserRepositoryImpl(userStorage = SharedPrefUserStorage(context = applicationContext))
    }
    private val getUserNameUseCase by lazy(LazyThreadSafetyMode.NONE) {
        GetUserNameUseCase(userRepository = userRepository)
    }
    private val saveUserNameUseCase by lazy(LazyThreadSafetyMode.NONE) {
        SaveUserNameUseCase(userRepository = userRepository)
    }

    private lateinit var vm: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.e("AAA", "Activity created")
        vm = ViewModelProvider(this, MainViewModelFactory(this)).get(MainViewModel::class.java)

        val dataTextView = findViewById<TextView>(R.id.dataTextView)
        val dataEditView = findViewById<EditText>(R.id.dataEditText)
        val sendButton = findViewById<Button>(R.id.sendButton)
        val receiveButton = findViewById<Button>(R.id.receiveButton)

        vm.resultLive.observe(this) { text ->
            dataTextView.text = text
        }

        sendButton.setOnClickListener {
            val text = dataEditView.text.toString()
            vm.save(text)
        }

        receiveButton.setOnClickListener {
            vm.load()
        }

    }
}

