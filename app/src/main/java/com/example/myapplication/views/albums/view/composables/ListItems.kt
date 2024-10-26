package com.example.myapplication.views.albums.view.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.myapplication.common.extensions.ToHeight

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun ListItem(
    imageUrl: String,
    artistName: String,
    trackName: String,
    ) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        GlideImage(
            model = imageUrl,
            contentDescription = "Artist Image",
            modifier = Modifier.fillMaxSize(
                fraction = 0.2f
            )
        )
        Column {
            Text(artistName)
            20.ToHeight()
            Text(trackName)
        }
    }
}



@Preview(showBackground = true)
@Composable
fun ListItemPreview() {
    ListItem(
        "https://is1-ssl.mzstatic.com/image/thumb/Music5/v4/fd/55/b1/fd55b163-4641-32df-706a-5917b9cb" +
                "46b2/887845623317.jpg/100x100bb.jpg",
        "Artist Name",
        "Track Name"
    )

}