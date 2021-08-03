package com.rizaldev.interactivetodolist.common

import com.rizaldev.interactivetodolist.features.home.data.model.ContentEntity
import retrofit2.Call
import retrofit2.http.GET


interface ApiService {

    @GET("list_json/all_list.json")
    fun getHomeContent(): Call<List<ContentEntity>>
}