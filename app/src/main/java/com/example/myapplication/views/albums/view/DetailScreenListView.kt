package com.example.myapplication.views.albums.view

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.myapplication.views.albums.view.composables.ListItem
import com.example.myapplication.views.homepage.data.models.ItunesModel
import com.example.myapplication.views.homepage.viewmodel.EntityType


@SuppressLint("SuspiciousIndentation")
@Composable
fun AlbumListView(
    items: MutableMap<EntityType, ItunesModel>
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        items.forEach { (header, itemsList) ->
            if(itemsList.results.isNotEmpty())
            item {
                Text(
                    text = header.name,
                    style = MaterialTheme.typography.headlineSmall,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 8.dp)
                        .background(MaterialTheme.colorScheme.primary.copy(alpha = 0.2f))
                )
            }

            // List of items under the header
            items(itemsList.results) { item ->
                if (itemsList.results.isNotEmpty())
                    ListItem(
                        imageUrl = item.artworkUrl60?: "",
                        artistName = item.artistName ?: "",
                        trackName = item.trackName ?: ""
                    )
            }
        }
    }
}
