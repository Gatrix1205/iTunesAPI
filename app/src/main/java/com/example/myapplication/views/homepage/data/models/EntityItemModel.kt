package com.example.myapplication.views.homepage.data.models

import com.example.myapplication.views.homepage.viewmodel.EntityType

data class EntityItemModel(
    val id: Int,
    var isSelected: Boolean = false,
    var name: EntityType
)