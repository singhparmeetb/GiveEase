package com.example.virtusa

import android.content.Context
import android.net.Uri
import android.provider.MediaStore
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import com.example.virtusa.ui.theme.comfortaalight
import java.io.File

@Preview(showBackground=true)
@Composable
fun previewsignUpScreen(){
    SignUpScreen(navController = rememberNavController())
}

@Composable
fun SignUpScreen(navController: NavController) {
    var name by remember { mutableStateOf("") }
    var mobileNumber by remember { mutableStateOf("") }
    var birthDate by remember { mutableStateOf("") }
    var postalCode by remember { mutableStateOf("") }
    var isCheckboxChecked by remember { mutableStateOf(false) }
    val uploadedImageUri = remember { mutableStateOf<Uri?>(null) }
//    val onImageSelected: (File) -> Unit = { file ->
//        uploadedImageFile.value = file
//    }


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
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Upload Image
//            UploadImageSection(uploadedImageFile,onImageSelected)
            UploadImageSection(
                uploadedImageUri = uploadedImageUri,
                onImageSelected = { uri ->
                    uploadedImageUri.value = uri
                }
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Enter Name
            TextField(
                value = name,
                onValueChange = { name = it },
                label = { Text("Enter your name", fontFamily = comfortaalight) }
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Enter Mobile Number
            TextField(
                value = mobileNumber,
                onValueChange = { mobileNumber = it },
                label = { Text("Enter your mobile number", fontFamily = comfortaalight) },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Enter Birth Date
            TextField(
                value = birthDate,
                onValueChange = { birthDate = it },
                label = { Text("Enter your birth date", fontFamily = comfortaalight) }
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Enter Postal Code
            TextField(
                value = postalCode,
                onValueChange = { postalCode = it },
                label = { Text("Enter your postal code", fontFamily = comfortaalight) }
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Optional Checkbox
            Row(verticalAlignment = Alignment.CenterVertically) {
                Checkbox(
                    checked = isCheckboxChecked,
                    onCheckedChange = { isCheckboxChecked = it }
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = "Receive Updates & Newsletters", fontFamily = comfortaalight)
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Continue Button
            Button(
                onClick = { /* Handle button click */ },
                enabled = name.isNotBlank() && mobileNumber.length == 10 && birthDate.isNotBlank() && postalCode.isNotBlank(),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "Continue",modifier= Modifier.clickable { navController.navigate("mainScreen") })
            }
        }
    }
}

@Composable
fun UploadImageSection(uploadedImageUri: MutableState<Uri?>, onImageSelected: (Uri) -> Unit) {
    val context = LocalContext.current
    val uploadedImageFile = remember { mutableStateOf<File?>(null) }
    val imagePickerLauncher = rememberLauncherForActivityResult(contract = ActivityResultContracts.GetContent()) { uri ->
        // Handle the selected image URI here
        if (uri != null) {
            uploadedImageUri.value=uri
            onImageSelected(uri)
            Toast.makeText(context, "Profile Updated", Toast.LENGTH_SHORT).show()
        }
    }

    Box(
        modifier = Modifier
            .size(120.dp)
            .padding(bottom = 16.dp),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier= Modifier
                .clip(CircleShape)
                .size(120.dp)
                .background(Color.LightGray)
        ) {
            val painter = rememberAsyncImagePainter(uploadedImageUri.value)
            Image(
                painter = painter,
                contentDescription = "Uploaded Image",
                modifier = Modifier
                    .fillMaxSize()
                    .clip(CircleShape)
                    .background(Color.LightGray),
                contentScale = ContentScale.Crop
            )
        }
        Button(
            onClick = {
                imagePickerLauncher.launch("image/*")
            },
            modifier = Modifier.fillMaxSize(),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Transparent),
            contentPadding = PaddingValues()
        ) {
        // Customize the button appearance here
        }
    }
    Text(
        text = "Upload your image",
        style = TextStyle(color = Color.Black),
        fontFamily = comfortaalight
    )
}

private fun getFileFromUri(context: Context, uri: Uri): File? {
    val filePathColumn = arrayOf(MediaStore.Images.Media.DATA)
    val cursor = context.contentResolver.query(uri, filePathColumn, null, null, null)
    cursor?.use {
        it.moveToFirst()
        val columnIndex = it.getColumnIndex(filePathColumn[0])
        return it.getString(columnIndex)?.let { path -> File(path) }
    }
    return null
}
