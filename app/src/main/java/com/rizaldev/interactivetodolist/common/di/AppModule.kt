package com.rizaldev.interactivetodolist.common.di

import com.rizaldev.interactivetodolist.features.home.data.HomeRepositoryImpl
import com.rizaldev.interactivetodolist.features.home.domain.HomeRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.scopes.FragmentScoped
import dagger.hilt.android.scopes.ViewModelScoped
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideHomeRepository(): HomeRepository = HomeRepositoryImpl()
}