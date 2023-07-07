import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.res.painterResource

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.semantics.Role.Companion.Button
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.virtusa.R
import com.example.virtusa.ui.theme.comfortaalightsemibold
import com.example.virtusa.ui.theme.retard
import com.example.virtusa.userlogin

@Preview
@Composable
fun greetingScreenPreview(){
    greetingscreen(navController = rememberNavController())
}

@Composable
fun greetingscreen(navController:NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .fillMaxWidth()
            .background(Color.White)
    ) {
        Image(
            painter = painterResource(id =R.drawable.bg_1), // Replace with your image resource
            contentDescription = "Background Image",
            modifier = Modifier.fillMaxHeight(),
            contentScale = ContentScale.FillHeight
        )
        Column(
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(bottom = 24.dp)
        ) {
            Text(
                text = "Let's",
                modifier = Modifier.padding(start = 10.dp,end=35.dp),
                fontSize = 50.sp,
                fontFamily = retard,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "Get",
                modifier = Modifier.padding(start = 10.dp,end=35.dp),
                fontSize = 50.sp,
                fontFamily = retard,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "Started",
                modifier = Modifier.padding(start = 10.dp,end=35.dp, bottom = 100.dp),
                fontSize = 50.sp,
                fontFamily = retard,
                fontWeight = FontWeight.Bold
            )
            Button(
                onClick = {navController.navigate("userLoginScreen")},
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(97,79,200),
                    contentColor = Color.Black) ,
                modifier = Modifier.align(CenterHorizontally).padding(start=65.dp)
                    .height(69.dp).width(200.dp)
            ) {
                Text(text = "Join Now",
                    fontFamily = comfortaalightsemibold,
                fontSize = 30.sp,)

            }
        }

    }
}



