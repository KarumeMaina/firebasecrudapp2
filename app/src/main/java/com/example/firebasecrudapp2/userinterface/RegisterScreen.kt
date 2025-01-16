package com.example.firebasecrudapp2.userinterface


import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.firebasecrudapp2.viewmodel.UserViewModel

@Composable
fun RegisterScreen(userViewModel: UserViewModel = viewModel()) {
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        TextField(value = name, onValueChange = { name = it }, label = { Text("Name") })
        Spacer(modifier = Modifier.height(8.dp))
        TextField(value = email, onValueChange = { email = it }, label = { Text("Email") })
        Spacer(modifier = Modifier.height(8.dp))
        TextField(value = password, onValueChange = { password = it }, label = { Text("Password") })
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            userViewModel.registerUser(name, email, password) { success, message ->
                if (success) {
                    // Handle success
                } else {
                    // Handle error
                }
            }
        }) {
            Text("Register")
        }
    }
}

@Composable
fun TextField(value: String, onValueChange: () -> Unit, label: () -> Unit) {

}
