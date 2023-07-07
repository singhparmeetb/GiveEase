package com.example.virtusa

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.virtusa.ui.theme.comfortaalight
import com.example.virtusa.ui.theme.comfortaalightsemibold
import com.example.virtusa.ui.theme.comfortaamedium
import com.example.virtusa.ui.theme.retard

@Preview(showBackground=true)
@Composable
fun preview(){
    userSignUp(navController = rememberNavController())
}

@Composable
fun userSignUp(navController: NavController) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Image(
            painter = painterResource(id =R.drawable.usersignupscreen), // Replace with your image resource
            contentDescription = "Background Image",
            modifier = Modifier.fillMaxHeight(),
            contentScale = ContentScale.FillHeight
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Create",
                fontSize = 50.sp,
                fontFamily = retard,
                modifier = Modifier.padding(top = 10.dp)
            )
            Text(
                text = "Your",
                fontSize = 50.sp,
                fontFamily = retard,
                modifier = Modifier
            )
            Text(
                text = "Account",
                fontSize = 50.sp,
                fontFamily = retard,
                modifier = Modifier.padding(bottom=10.dp)
            )

            Spacer(modifier = Modifier.height(69.dp))

            Text(
                text = "Enter your username and password",
                fontSize = 16.sp,
                fontFamily = comfortaalightsemibold,
                modifier = Modifier.padding(bottom = 32.dp)
            )

            TextField(
                value = email,
                onValueChange = { email = it },
                label = { Text(text = "Email", fontFamily = comfortaalight) },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true
            )

            Spacer(modifier = Modifier.height(16.dp))

            TextField(
                value = password,
                onValueChange = { password = it },
                label = { Text(text = "Create Password", fontFamily = comfortaalight) },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
                visualTransformation = PasswordVisualTransformation()
            )

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = { /* Perform login logic here */ navController.navigate("userInfo")},
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(97, 79, 200),
                    contentColor = Color.White
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(45.dp)
            ) {
                Text(text = "Sign Up", fontFamily = comfortaamedium, fontSize = 16.sp)
            }
        }
    }
}



