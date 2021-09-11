package com.rizaldev.interactivetodolist.features.home.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.rizaldev.interactivetodolist.databinding.ViewHomeContentBinding
import com.rizaldev.interactivetodolist.features.home.domain.model.Content

class HomeContentAdapter :
    RecyclerView.Adapter<HomeContentViewHolder>() {

    private val content = mutableListOf<Content>()
    private lateinit var binding: ViewHomeContentBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeContentViewHolder {
        binding = ViewHomeContentBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return HomeContentViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HomeContentViewHolder, position: Int) {
        binding.textTitle.text = content[position].title
        binding.textDescription.text = content[position].description
        Glide.with(binding.root)
            .load(content[position].imageUrl)
            .centerCrop()
            .into(binding.imageContent)
        binding.root.setOnClickListener {
            when (content[position].type) {
                MEDIUM -> {
                    Toast.makeText(
                        binding.root.context,
                        "Medium Clicked",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                ANDROID -> {
                    Toast.makeText(
                        binding.root.context,
                        "Android Clicked",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                SOFTWARE_ENGINEERING -> {
                    Toast.makeText(
                        binding.root.context,
                        "Software Engineer Clicked",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }

    fun addItem(content: List<Content>) {
        this.content.addAll(content)
        val insertIndex = when {
            content.isEmpty() -> 0
            else -> content.size - 1
        }
        notifyItemInserted(insertIndex)
    }

    override fun getItemCount(): Int {
        return content.size
    }

    companion object {
        const val MEDIUM = "MEDIUM"
        const val ANDROID = "ANDROID"
        const val SOFTWARE_ENGINEERING = "SOFTWARE_ENGINEERING"
    }
}
