package com.example.firebasecrudapp2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.firebasecrudapp2.userinterface.LoginScreen
import com.example.firebasecrudapp2.userinterface.RegisterScreen
//import com.example.firebasecrudapp2.ui.RegisterScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var showLoginScreen by remember { mutableStateOf(false) }

            if (showLoginScreen) {
                LoginScreen(onLoginSuccess = {
                    // Handle successful login
                })
            } else {
                RegisterScreen(onRegistrationSuccess = {
                    // Handle successful registration
                    showLoginScreen = true
                })
            }
        }
    }
}