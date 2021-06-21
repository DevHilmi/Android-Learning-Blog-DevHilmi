package com.rizaldev.interactivetodolist.di.module

import android.content.Context
import com.rizaldev.interactivetodolist.common.RootBaseActivity
import dagger.Module
import dagger.Provides

@Module
class ActivityModule constructor(private val activity: RootBaseActivity) {

    @Provides
    fun providesActivityContext() : Context = activity.application

    @Provides
    fun providesActivity() : RootBaseActivity { return activity}

}