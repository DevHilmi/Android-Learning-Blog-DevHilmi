package com.rizaldev.interactivetodolist.features.splash.ui

import android.content.Intent
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.rizaldev.interactivetodolist.common.base.BaseActivity
import com.rizaldev.interactivetodolist.databinding.ActivitySplashBinding
import com.rizaldev.interactivetodolist.features.main.ui.MainActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashActivity :
    BaseActivity<SplashIntent, SplashAction, SplashState, SplashViewModel, ActivitySplashBinding>(
        SplashViewModel::class.java
    ) {

    override fun getLayoutViewBinding(): ActivitySplashBinding {
        return ActivitySplashBinding.inflate(layoutInflater)
    }

    override fun getViewModelImp(): SplashViewModel {
        val viewModel: SplashViewModel by viewModels()
        return viewModel
    }

    override fun initUi() {

    }

    override fun initData() {

    }

    override fun initEvent() {
        delayToHome()
    }

    override fun render(state: SplashState) {

    }

    private fun delayToHome() {
        lifecycleScope.launch(Dispatchers.Main) {
            delay(1000L)
            val intent = Intent(baseContext, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

}