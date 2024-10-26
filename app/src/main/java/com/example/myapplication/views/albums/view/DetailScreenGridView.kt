package com.example.myapplication.views.albums.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.myapplication.views.albums.view.composables.GridViewLayout
import com.example.myapplication.views.homepage.data.models.ItunesModel
import com.example.myapplication.views.homepage.viewmodel.EntityType

@Composable
fun AlbumGridView(
    items: MutableMap<EntityType, ItunesModel>
) {
    LazyVerticalGrid (
        columns = GridCells.Fixed(count = 3)
    ) {
        items.forEach { (header, itemsList) ->
            if (itemsList.results.isNotEmpty())
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
                    GridViewLayout(
                        imageUrl = item.artworkUrl60 ?: "",
                        albumName = item.artistName ?: ""
                    )
            }
        }
    }
}