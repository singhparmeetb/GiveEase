package com.example.virtusa.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.virtusa.R

// Set of Material typography styles to start with
val retard= FontFamily(Font(R.font.goodtimes))
val comfortaalightsemibold=FontFamily(Font(R.font.comfortaalightsemibold))
val comfortaalight=FontFamily(Font(R.font.comfortaalight))
val comfortaaregular=FontFamily(Font(R.font.comfortaaregular))
val comfortaabold=FontFamily(Font(R.font.comfortaabold))
val comfortaamedium=FontFamily(Font(R.font.comfortaamedium))
val Typography = Typography(
        bodyLarge = TextStyle(
                fontFamily = FontFamily.Default,
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp,
                lineHeight = 24.sp,
                letterSpacing = 0.5.sp
        )
        /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)