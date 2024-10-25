package com.example.myapplication.views.albums.view

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
import com.example.myapplication.views.homepage.data.models.ItunesModel
import com.example.myapplication.views.homepage.viewmodel.EntityType


@Composable
fun AlbumListView(
    items: MutableMap<EntityType, ItunesModel>
){
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        items.forEach { (header, itemsList) ->
            // Regular header that scrolls with the content
            item {
                Text(
                    text = header.name,
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                        .background(MaterialTheme.colorScheme.primary.copy(alpha = 0.2f))
                )
            }

            // List of items under the header
            items(itemsList.results) { item ->
                Text(
                    text = item.trackName ?: "No track name available",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                )
            }
        }
    }
}
