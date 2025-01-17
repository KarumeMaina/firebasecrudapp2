package com.example.firebasecrudapp2.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.firebasecrudapp2.repository.FirebaseRepository
import kotlinx.coroutines.launch
import androidx.compose.runtime.mutableStateOf
//import androidx.lifecycle.ViewModel

class UserViewModel : ViewModel() {
    // Observable registration state
    var registrationState = mutableStateOf<String?>(null)
        private set

    // Observable login state
    var loginState = mutableStateOf<String?>(null)
        private set

    // Registration logic
    fun registerUser(name: String, email: String, password: String, onResult: (Boolean) -> Unit) {
        // Simulate a registration process
        if (name.isNotBlank() && email.isNotBlank() && password.length >= 6) {
            registrationState.value = "Success"
            onResult(true)
        } else {
            registrationState.value = "Failed: Invalid input"
            onResult(false)
        }
    }

    // Login logic
    fun loginUser(email: String, password: String, onResult: (Boolean, String?) -> Unit) {
        // Simulate Firebase Authentication
        if (email == "test@example.com" && password == "password123") {
            loginState.value = "Success"
            onResult(true, null) // Successful login
        } else {
            loginState.value = "Failed"
            onResult(false, "Invalid email or password") // Failed login
        }
    }
}

