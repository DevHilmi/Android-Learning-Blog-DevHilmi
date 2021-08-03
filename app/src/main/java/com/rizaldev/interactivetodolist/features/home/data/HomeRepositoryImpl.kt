package com.rizaldev.interactivetodolist.features.home.data

import android.util.Log
import com.rizaldev.interactivetodolist.common.ApiService
import com.rizaldev.interactivetodolist.features.home.data.model.ContentEntity
import com.rizaldev.interactivetodolist.features.home.domain.HomeRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class HomeRepositoryImpl : HomeRepository {

    override fun getHomeContent(): Result<List<ContentEntity>> {
        return Result.success(listOf(
            ContentEntity("a", "a", "a", "a", "a"),
            ContentEntity("a", "a", "a", "a", "a"),
            ContentEntity("a", "a", "a", "a", "a"),
            ContentEntity("a", "a", "a", "a", "a")
        ))
    }
}