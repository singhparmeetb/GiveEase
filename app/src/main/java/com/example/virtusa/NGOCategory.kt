package com.example.virtusa

import androidx.compose.ui.graphics.Color

data class NGO(
    val name: String,
    val image: Int,
    val backgroundColor: Color,
    val url:String
)
data class Category(
    val title: String,
    val image: Int,
    val backgroundColor: Color
)