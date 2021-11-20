package com.bcoding.travelappui

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Color


data class Buddie(val id: Int, val name: String, val age: Int, val status: String, val color: Color, @DrawableRes val image: Int)
