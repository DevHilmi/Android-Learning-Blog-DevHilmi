package com.rizaldev.interactivetodolist.features.home.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.rizaldev.interactivetodolist.R
import com.rizaldev.interactivetodolist.common.base.BaseFragment
import com.rizaldev.interactivetodolist.databinding.FragmentHomeBinding

class HomeFragment :
    BaseFragment<HomeIntent, HomeAction, HomeState, HomeViewModel, FragmentHomeBinding>(
        HomeViewModel::class.java
    ) {

    override fun getLayoutViewBinding(): FragmentHomeBinding {
        return FragmentHomeBinding.inflate(layoutInflater)
    }

    override fun getViewModelImp(): HomeViewModel {
        val viewModel by viewModels<HomeViewModel>()
        return viewModel
    }

    override fun initUi() {
        val mockList = listOf("Test", "Test2")
        val adapter = HomeContentAdapter(mockList)
        val linearLayoutManager = LinearLayoutManager(context)
        binding.recyclerContent.layoutManager = linearLayoutManager
        binding.recyclerContent.adapter = adapter
        adapter.notifyDataSetChanged()
    }

    override fun initData() {

    }

    override fun initEvent() {
    }

    override fun render(state: HomeState) {
    }

    class HomeContentAdapter(private val dataset: List<String>) :
        RecyclerView.Adapter<HomeContentViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeContentViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.view_home_content, parent, false)
            return HomeContentViewHolder(view)
        }

        override fun onBindViewHolder(holder: HomeContentViewHolder, position: Int) {

        }

        override fun getItemCount(): Int {
            return dataset.size
        }
    }
}