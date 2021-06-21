package com.rizaldev.interactivetodolist.di.component

import com.rizaldev.interactivetodolist.common.RootBaseActivity
import com.rizaldev.interactivetodolist.di.annotations.ActivityScope
import com.rizaldev.interactivetodolist.di.module.ActivityModule
import dagger.Component

@ActivityScope
@Component(modules = [ActivityModule::class], dependencies = [ApplicationComponent::class])
interface ActivityComponent {
    fun inject(baseActivity: RootBaseActivity)
}