package com.rizaldev.interactivetodolist.features.home.ui.adapter

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.rizaldev.interactivetodolist.databinding.ViewHomeContentBinding
import com.rizaldev.interactivetodolist.features.home.ui.model.ContentModel

class HomeContentViewHolder(private val binding: ViewHomeContentBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun init(contentModel: ContentModel) {
        binding.textTitle.text = contentModel.title
        binding.textDescription.text = contentModel.description
        Glide.with(binding.root)
            .load(contentModel.imageUrl)
            .centerCrop()
            .into(binding.imageContent)
    }
}


