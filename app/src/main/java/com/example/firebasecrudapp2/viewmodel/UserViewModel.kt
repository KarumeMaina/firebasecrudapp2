package com.example.firebasecrudapp2.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.firebasecrudapp2.repository.FirebaseRepository
import kotlinx.coroutines.launch

class UserViewModel: ViewModel() {
    private val repository = FirebaseRepository()


    fun registerUser(name: String, email: String, password: String, onResult: (Boolean, String?) -> Unit) {
        viewModelScope.launch {
            try {
                val userId = repository.registerUser(name, email, password)
                onResult(true, userId)
            } catch (e: Exception) {
                onResult(false, e.message)
            }
        }
    }

    fun loginUser(email: String, password: String, onResult: (Boolean, String?) -> Unit){
        viewModelScope.launch {
            try {
                val userId = repository.loginUser(email, password)
                onResult(true, userId)
            } catch (e: Exception) {
                onResult(false, e.message)
            }
        }
    }
}
