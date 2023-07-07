package com.example.virtusa

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.virtusa.ui.theme.retard
@Preview(showBackground =true)
@Composable
fun previewgreeting(){
    greetingScreen(navController = rememberNavController())
}

@Composable
fun greetingScreen(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {

        Image(
            painter = painterResource(id = R.drawable.bg_1), // Replace with your image resource
            contentDescription = "Background Image",
            modifier = Modifier.fillMaxHeight(),
            contentScale = ContentScale.FillHeight
        )


        Text(
            text = "Thank",
            modifier = Modifier.padding(bottom = 100.dp, start = 10.dp, end = 35.dp, top = 60.dp),
            fontSize = 55.sp,
            fontFamily = retard,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = "You",
            modifier = Modifier.padding(start = 10.dp, end = 35.dp,top=130.dp),
            fontSize = 55.sp,
            fontFamily = retard,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(69.dp))


        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "We will get back to you in 24 hours",
                fontSize = 20.sp,
                fontFamily = retard,
                modifier = Modifier.padding(bottom = 8.dp, top = 10.dp)
            )


        }
    }
}