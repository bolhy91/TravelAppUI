package com.bcoding.travelappui.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.bcoding.travelappui.R


val gtWalsheimPro = FontFamily(listOf(
    Font(R.font.gtwalsheimpro_regular, FontWeight.Normal),
    Font(R.font.gtwalsheimpro_medium, FontWeight.Medium),
    Font(R.font.gtwalsheimpro_bold, FontWeight.Bold),
    Font(R.font.gtwalsheimpro_black, FontWeight.Black),
))

// Set of Material typography styles to start with
val Typography = Typography(
    body1 = TextStyle(
        fontFamily = gtWalsheimPro,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    ),
    h1 = TextStyle(
        color = Color.White,
        fontFamily = gtWalsheimPro,
        fontWeight = FontWeight.Bold,
        fontSize = 22.sp
    ),
    h2 = TextStyle(
        color = Color.White,
        fontFamily = gtWalsheimPro,
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp
    ),
    button = TextStyle(
        fontFamily = gtWalsheimPro,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = gtWalsheimPro,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
)