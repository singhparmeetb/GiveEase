package com.example.virtusa

import android.content.Context
import android.net.Uri
import android.provider.MediaStore
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
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
import androidx.compose.ui.platform.LocalContext
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
import java.io.File

@Preview(showBackground=true)
@Composable
fun NGOpreview(){
    ngoVerification(navcontroller = rememberNavController())
}

@Composable
fun ngoVerification(navcontroller:NavController) {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Image(
            painter = painterResource(id = R.drawable.ngologin), // Replace with your image resource
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
                text = "Verify Your",
                fontSize = 30.sp,
                fontFamily = retard,
                modifier = Modifier.padding(bottom = 10.dp, top = 10.dp)
            )
            Text(
                text = "NGO Account",
                fontSize = 30.sp,
                fontFamily = retard,
                modifier = Modifier.padding(top = 3.dp)
            )

            Spacer(modifier = Modifier.height(100.dp))

            Text(
                text = "Enter your Registration ID",
                fontSize = 25.sp,
                fontFamily = comfortaalightsemibold,
                modifier = Modifier.padding(bottom = 32.dp)
            )

            TextField(
                value = username,
                onValueChange = { username = it },
                label = { Text(text = "Registration ID", fontFamily = comfortaalight) },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Upload Your Registration Certificate",
                fontSize = 20.sp,
                fontFamily = comfortaalightsemibold,
                modifier = Modifier.padding(bottom = 32.dp)
            )
            fun getFileFromUri(context: Context, uri: Uri): File? {
                val filePathColumn = arrayOf(MediaStore.Images.Media.DATA)
                val cursor = context.contentResolver.query(uri, filePathColumn, null, null, null)
                cursor?.use {
                    it.moveToFirst()
                    val columnIndex = it.getColumnIndex(filePathColumn[0])
                    val filePath = it.getString(columnIndex)
                    if (!filePath.isNullOrEmpty()) {
                        return File(filePath)
                    }
                }
                return null
            }

            @Composable
            fun UploadCertificateSection(
                onCertificateSelected: (File) -> Unit,
                onCertificateUploaded: (String) -> Unit
            ) {
                val context = LocalContext.current
                val certificatePickerLauncher =
                    rememberLauncherForActivityResult(contract = ActivityResultContracts.GetContent()) { uri ->
                        val selectedFile = getFileFromUri(context, uri!!)
                        onCertificateSelected(selectedFile!!)

                        // Upload the selected certificate file to the backend and get the URL
                        // Replace the following code with your actual upload logic
                        // val certificateUrl = uploadCertificateToBackend(selectedFile)
                        // onCertificateUploaded(certificateUrl)
                    }

                Column(
                    modifier = Modifier.padding(vertical = 16.dp)
                ) {
                    Button(
                        onClick = {
                            certificatePickerLauncher.launch("application/pdf")
                        },
                        modifier = Modifier.align(Alignment.CenterHorizontally)
                    ) {
                        Text(text = "Upload Certificate")
                    }
                }
            }




            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = { /* Perform login logic here */navcontroller.navigate("ThankYou") },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(97, 79, 200),
                    contentColor = Color.White
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(45.dp)
            ) {
                Text(text = "Login", fontFamily = comfortaamedium, fontSize = 16.sp)
            }
        }
    }
}






