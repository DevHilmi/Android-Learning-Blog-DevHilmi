package com.rizaldev.interactivetodolist.features.home.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.rizaldev.interactivetodolist.databinding.ViewHomeContentBinding
import com.rizaldev.interactivetodolist.features.home.ui.model.ContentModel

class HomeContentAdapter :
    ListAdapter<ContentModel, HomeContentViewHolder>(ContentModelDiffCallback()) {

    private lateinit var binding: ViewHomeContentBinding
    private var onHomeContentAdapterListener: OnHomeContentAdapterListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeContentViewHolder {
        binding = ViewHomeContentBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return HomeContentViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HomeContentViewHolder, position: Int) {
        val contentModel = getItem(position)
        holder.init(contentModel)
        binding.root.setOnClickListener {
            onHomeContentAdapterListener?.itemClick(contentModel.id)
        }
    }

    fun setOnHomeContentAdapterListener(onHomeContentAdapterListener: OnHomeContentAdapterListener) {
        this.onHomeContentAdapterListener = onHomeContentAdapterListener
    }
}

interface OnHomeContentAdapterListener {
    fun itemClick(position: Int)
}
