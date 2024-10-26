package com.example.myapplication.views.albums.view.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun GridViewLayout(
    imageUrl: String,
    albumName: String
){
    Column {
        GlideImage(
            model = imageUrl,
            contentDescription = "Artist Image",
            modifier = Modifier.fillMaxSize(
                fraction = 0.2f
            )
        )
        Text(albumName)

    }

}