package com.rizaldev.interactivetodolist.features.home.domain.mapper

import com.rizaldev.interactivetodolist.features.home.data.model.ContentEntity
import com.rizaldev.interactivetodolist.features.home.domain.model.Content

fun ContentEntity.toContent() = Content(
    id = id,
    title = title,
    description = description,
    imageUrl = imageUrl,
    markdownUrl = markdownUrl,
    type = type
)

fun List<ContentEntity>.toListContent(): List<Content> {
    val result = mutableListOf<Content>()
    repeat(this.size) {
        result.add(this[it].toContent())
    }
    return result
}