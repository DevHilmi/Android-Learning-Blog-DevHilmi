package com.rizaldev.interactivetodolist.features.home.ui.model

import com.rizaldev.interactivetodolist.features.home.domain.model.Content

fun Content.toContentModel() = ContentModel(
    id = id,
    title = title,
    description = description,
    imageUrl = imageUrl,
    markdownUrl = markdownUrl,
    type = type
)

fun List<Content>.toListContentModel(): List<ContentModel> {
    val result = mutableListOf<ContentModel>()
    repeat(this.size) {
        result.add(this[it].toContentModel())
    }
    return result
}