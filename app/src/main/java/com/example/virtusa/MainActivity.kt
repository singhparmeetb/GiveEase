package com.example.virtusa

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.virtusa.ui.theme.VirtusaTheme
import greetingscreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            VirtusaTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = "greetingscreen") {
                        composable("userLoginScreen") {
                            userlogin(navController)
                        }
                        composable("greetingScreen") {
                            greetingscreen(navController)
                        }
                        composable("mainScreen"){
                            MainScreen(navController)
                        }
                        composable("ngoLogin"){
                            ngoLogin(navController)
                        }
                        composable("createAccount"){
                            userSignUp(navController)
                        }
                        composable("userInfo"){
                            SignUpScreen(navController)
                        }
                        composable("ngoRegistration"){
                            ngoVerification(navController)
                        }
                        composable("ThankYou"){
                            greetingScreen(navController)
                        }
                    }
                }
            }
        }
    }
}

