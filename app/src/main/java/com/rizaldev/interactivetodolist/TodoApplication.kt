package com.rizaldev.interactivetodolist

import android.app.Application
import com.rizaldev.interactivetodolist.di.component.ApplicationComponent
import com.rizaldev.interactivetodolist.di.component.DaggerApplicationComponent

class TodoApplication : Application() {

    companion object {
        lateinit var appComponents: ApplicationComponent
    }

    override fun onCreate() {
        super.onCreate()
        appComponents = initDependenciesInjection()
    }

    private fun initDependenciesInjection(): ApplicationComponent =
        DaggerApplicationComponent.builder().application(this).build()

}