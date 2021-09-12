package com.rizaldev.interactivetodolist.features.home.ui.adapter

import androidx.recyclerview.widget.DiffUtil
import com.rizaldev.interactivetodolist.features.home.ui.model.ContentModel

class ContentModelDiffCallback : DiffUtil.ItemCallback<ContentModel>() {
    override fun areItemsTheSame(oldItem: ContentModel, newItem: ContentModel): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: ContentModel, newItem: ContentModel): Boolean {
        return oldItem == newItem
    }
}