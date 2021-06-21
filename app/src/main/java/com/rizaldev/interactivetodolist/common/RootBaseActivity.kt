package com.rizaldev.interactivetodolist.common

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.rizaldev.interactivetodolist.TodoApplication
import com.rizaldev.interactivetodolist.di.component.ActivityComponent
import com.rizaldev.interactivetodolist.di.component.DaggerActivityComponent
import com.rizaldev.interactivetodolist.di.module.ActivityModule
import com.rizaldev.interactivetodolist.di.viewmodels.DaggerViewModelFactory
import javax.inject.Inject

open class RootBaseActivity : AppCompatActivity() {

    private val activityComponent: ActivityComponent by lazy {
        DaggerActivityComponent.builder().activityModule(ActivityModule(this))
            .applicationComponent(TodoApplication.appComponents).build()
    }

    @Inject
    lateinit var viewModelFactory: DaggerViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        activityComponent.inject(this)
        super.onCreate(savedInstanceState)
    }
}