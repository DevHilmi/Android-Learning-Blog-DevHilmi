package com.rizaldev.interactivetodolist.features.home.ui

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.rizaldev.interactivetodolist.common.base.BaseFragment
import com.rizaldev.interactivetodolist.databinding.FragmentHomeBinding
import com.rizaldev.interactivetodolist.features.android.components.ui.AndroidComponentActivity
import com.rizaldev.interactivetodolist.features.home.ui.adapter.HomeContentAdapter
import com.rizaldev.interactivetodolist.features.home.ui.adapter.OnHomeContentAdapterListener
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
        adapter.setOnHomeContentAdapterListener(object : OnHomeContentAdapterListener {
            override fun itemClick(position: Int) {
                when (position) {
                    1 -> {
                        // no implementation yet
                    }

                    2 -> {
                        val intent = Intent(activity, AndroidComponentActivity::class.java)
                        startActivity(intent)
                    }
                }
            }
        })
    }

    override fun render(state: HomeState) {
        when (state) {
            is HomeState.Loading -> {

            }

            is HomeState.ContentData -> {
                adapter.submitList(state.data)
            }

            is HomeState.Exception -> {

            }
        }
    }

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentHomeBinding
        get() = FragmentHomeBinding::inflate

}