package com.rizaldev.interactivetodolist.features.main.ui

import android.view.LayoutInflater
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.rizaldev.interactivetodolist.R
import com.rizaldev.interactivetodolist.common.base.BaseActivity
import com.rizaldev.interactivetodolist.databinding.ActivityMainBinding
import com.rizaldev.interactivetodolist.features.home.ui.HomeFragment
import com.rizaldev.interactivetodolist.features.settings.ui.SettingsFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity :
    BaseActivity<MainIntent, MainAction, MainState, MainViewModel, ActivityMainBinding>(
        MainViewModel::class.java
    ) {

    override fun getViewModelImp(): MainViewModel {
        val viewModel: MainViewModel by viewModels()
        return viewModel
    }

    override fun initUi() {
        binding.viewPagerMain.adapter = MainPagerAdapter(this)
        binding.bottomNavigation.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.homePage -> {
                    binding.viewPagerMain.currentItem = 0
                    true
                }
                R.id.settingPage -> {
                    binding.viewPagerMain.currentItem = 1
                    true
                }
                else -> false
            }
        }
        binding.viewPagerMain.isUserInputEnabled = false
    }

    override fun initData() {
        // no implementation
    }

    override fun initEvent() {
        // no implementation
    }

    override fun render(state: MainState) {
       // no implementation
    }

    class MainPagerAdapter(fragmentActivity: FragmentActivity) :
        FragmentStateAdapter(fragmentActivity) {

        override fun getItemCount(): Int {
            return NUM_PAGES
        }

        override fun createFragment(position: Int): Fragment {
            return when (position) {
                0 -> HomeFragment()
                1 -> SettingsFragment()
                else -> HomeFragment()
            }
        }
    }

    companion object {
        private const val NUM_PAGES = 2
    }

    override val bindingInflater: (LayoutInflater) -> ActivityMainBinding
        get() = ActivityMainBinding::inflate

}