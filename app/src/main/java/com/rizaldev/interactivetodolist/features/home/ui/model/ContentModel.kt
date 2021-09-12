package com.rizaldev.interactivetodolist.features.home.ui.model

data class ContentModel(
    val id: Int,
    val title: String,
    val description: String,
    val imageUrl: String,
    val markdownUrl: String,
    val type: String,
)
