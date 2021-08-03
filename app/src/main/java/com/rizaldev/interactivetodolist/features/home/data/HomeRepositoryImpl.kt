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
        return Result.success(
            listOf(
                ContentEntity(
                    "Transforming Pull Request Format at DANA Indonesia",
                    "Pull Request Review is a good thing to have on every software engineering company, it helps improving team knowledge and prevent bad code from going into the main code base of a project.",
                    "https://picsum.photos/200/200",
                    "a",
                    "MEDIUM"
                ),
                ContentEntity("a", "a", "a", "a", "a"),
                ContentEntity("a", "a", "a", "a", "a"),
                ContentEntity("a", "a", "a", "a", "a")
            )
        )
    }
}