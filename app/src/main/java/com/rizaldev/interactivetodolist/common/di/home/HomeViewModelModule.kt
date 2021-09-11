package com.rizaldev.interactivetodolist.common.di.home

import com.rizaldev.interactivetodolist.features.home.domain.GetHomeContent
import com.rizaldev.interactivetodolist.features.home.domain.HomeRepository
import com.rizaldev.interactivetodolist.features.home.ui.HomeReducers
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
class HomeViewModelModule {

    @Provides
    @ViewModelScoped
    fun provideHomeReducers(): HomeReducers = HomeReducers()

    @Provides
    @ViewModelScoped
    fun provideGetHomeContent(homeRepository: HomeRepository): GetHomeContent =
        GetHomeContent(homeRepository)
}