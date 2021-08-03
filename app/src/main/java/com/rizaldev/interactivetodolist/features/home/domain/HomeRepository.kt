package com.rizaldev.interactivetodolist.features.home.domain

import com.rizaldev.interactivetodolist.features.home.data.model.ContentEntity

interface HomeRepository {
    fun getHomeContent(): Result<List<ContentEntity>>
}