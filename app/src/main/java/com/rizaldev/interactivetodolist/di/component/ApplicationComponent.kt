package com.rizaldev.interactivetodolist.di.component

import com.rizaldev.interactivetodolist.TodoApplication
import com.rizaldev.interactivetodolist.di.module.ApplicationModule
import com.rizaldev.interactivetodolist.di.module.NetworkModule
import com.rizaldev.interactivetodolist.di.viewmodels.DaggerViewModelFactory
import com.rizaldev.interactivetodolist.di.viewmodels.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Component(modules = [ApplicationModule::class, NetworkModule::class, ViewModelModule::class])
@Singleton
interface ApplicationComponent {

    @Component.Builder
    interface Builder {
        fun build(): ApplicationComponent

        @BindsInstance
        fun application(app: TodoApplication): Builder
    }

    fun provideDaggerViewModelFactory(): DaggerViewModelFactory

}