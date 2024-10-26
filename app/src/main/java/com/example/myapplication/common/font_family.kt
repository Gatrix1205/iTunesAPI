package com.example.myapplication.common

import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import com.example.myapplication.R

object Constants {
    val notsFontFamily: FontFamily = FontFamily(
        Font(R.font.notosans_bold, FontWeight.Normal),
        Font(R.font.notosans_bolditalic, FontWeight.Normal)
    )
}