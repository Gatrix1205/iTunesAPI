package com.example.myapplication.views.homepage.view.composables

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import com.example.myapplication.views.homepage.data.models.EntityItemModel
import com.example.myapplication.views.homepage.viewmodel.HomePageViewModel

@Composable
fun EntityComposable(entityItemModel: EntityItemModel, viewModel: HomePageViewModel){
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(
            checked = entityItemModel.isSelected,
            onCheckedChange = {
                Log.i("Value", it.toString())
                entityItemModel.isSelected = it
                viewModel.updatedList(entityItemModel.id, entityItemModel.isSelected)
            }
        )
        Text(entityItemModel.name.toString())
    }
}