package com.rizaldev.interactivetodolist.features.main.ui

import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.tabs.TabLayoutMediator
import com.rizaldev.interactivetodolist.R
import com.rizaldev.interactivetodolist.common.base.BaseActivity
import com.rizaldev.interactivetodolist.databinding.ActivityMainBinding
import com.rizaldev.interactivetodolist.features.home.ui.HomeFragment
import com.rizaldev.interactivetodolist.features.settings.ui.SettingsFragment

class MainActivity :
    BaseActivity<MainIntent, MainAction, MainState, MainViewModel, ActivityMainBinding>(
        MainViewModel::class.java
    ) {

    override fun getLayoutViewBinding(): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }

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
        binding.viewPagerMain.registerOnPageChangeCallback(object :
            ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                when (position) {
                    0 -> binding.bottomNavigation.selectedItemId = R.id.homePage
                    1 -> binding.bottomNavigation.selectedItemId = R.id.settingPage
                }
            }
        })
    }

    override fun initData() {
        dispatchIntent(MainIntent.LoadAllTodos)
    }

    override fun initEvent() {

    }

    override fun render(state: MainState) {
        when (state) {
            is MainState.Loading -> {

            }

            is MainState.ResultAllTodo -> {

            }

            is MainState.Exception -> {

            }
        }
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

}