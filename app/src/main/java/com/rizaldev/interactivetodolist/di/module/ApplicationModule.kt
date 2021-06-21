package com.rizaldev.interactivetodolist.di.module

import android.content.Context
import com.rizaldev.interactivetodolist.TodoApplication
import dagger.Module
import dagger.Provides

@Module
class ApplicationModule {

    @Provides
    fun provideApplicationContext(application: TodoApplication): Context =
        application.applicationContext

}