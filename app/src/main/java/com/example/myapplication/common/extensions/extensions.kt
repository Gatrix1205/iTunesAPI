package com.example.myapplication.common.extensions

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun Int.ToHeight(){
    return Spacer(
        modifier = Modifier.height(this.dp)
    )
}