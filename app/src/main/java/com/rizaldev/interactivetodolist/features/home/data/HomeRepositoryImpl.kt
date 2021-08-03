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
                    "",
                    "MEDIUM"
                ),
                ContentEntity(
                    "Android Application Components",
                    "App components are the essential building blocks of an Android app. Each component is an entry point through which the system or a user can enter your app. Some components depend on others.",
                    "https://picsum.photos/201/201",
                    "",
                    "ANDROID"
                ),
                ContentEntity(
                    "Pragmatic Programmer Review",
                    "Each developer is unique, with individual strengths and weaknesses, preferences and dislikes. Over time, each will craft their own personal environment. That environment will reflect the programmer's individuality just as forcefully as his or her hobbies, clothing, or haircut. ",
                    "https://picsum.photos/202/202",
                    "",
                    "SOFTWARE_ENGINEERING"
                ),
                ContentEntity(
                    "Context in Android",
                    "The Context in Android is actually the context of what we are talking about and where we are currently present. This will become more clear as we go along with this.",
                    "https://picsum.photos/203/203",
                    "",
                    "ANDROID"
                )
            )
        )
    }
}