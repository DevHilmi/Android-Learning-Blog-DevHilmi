package com.rizaldev.interactivetodolist.features.home.data.model

data class ContentEntity(
    val id: Int,
    val title: String,
    val description: String,
    val imageUrl: String,
    val markdownUrl: String,
    val type: String,
)