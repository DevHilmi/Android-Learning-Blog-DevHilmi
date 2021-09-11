package com.rizaldev.interactivetodolist.features.home.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.rizaldev.interactivetodolist.common.base.BaseFragment
import com.rizaldev.interactivetodolist.databinding.FragmentHomeBinding
import com.rizaldev.interactivetodolist.databinding.ViewHomeContentBinding
import com.rizaldev.interactivetodolist.features.home.domain.model.Content
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.WithFragmentBindings

@WithFragmentBindings
@AndroidEntryPoint
class HomeFragment :
    BaseFragment<HomeIntent, HomeAction, HomeState, HomeViewModel, FragmentHomeBinding>(
        HomeViewModel::class.java
    ) {

    private val adapter = HomeContentAdapter()

    override fun getViewModelImp(): HomeViewModel {
        val viewModel by viewModels<HomeViewModel>()
        return viewModel
    }

    override fun initUi() {
        val linearLayoutManager = LinearLayoutManager(context)
        binding.recyclerContent.layoutManager = linearLayoutManager
        binding.recyclerContent.adapter = adapter
    }

    override fun initData() {
        dispatchIntent(HomeIntent.LoadHomeContent)
    }

    override fun initEvent() {
    }

    override fun render(state: HomeState) {
        when (state) {
            is HomeState.Loading -> {

            }

            is HomeState.ContentData -> {
                adapter.addItem(state.data)
            }

            is HomeState.Exception -> {

            }
        }
    }

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentHomeBinding
        get() = FragmentHomeBinding::inflate

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
}