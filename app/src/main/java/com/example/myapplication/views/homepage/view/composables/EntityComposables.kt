package com.example.myapplication.views.homepage.view.composables


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import com.example.myapplication.views.homepage.data.models.EntityItemModel


@Composable
fun EntityComposable(entityItemModel: EntityItemModel){
    var selected by remember {
        mutableStateOf(entityItemModel.isSelected)
    }
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(
            checked =selected,
            onCheckedChange = {
                selected = it
                entityItemModel.isSelected = selected }
        )
        Text(entityItemModel.name.toString())
    }
}