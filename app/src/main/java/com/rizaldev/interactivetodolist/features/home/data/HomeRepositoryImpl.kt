package com.rizaldev.interactivetodolist.features.home.data

import com.rizaldev.interactivetodolist.features.home.data.model.ContentEntity
import com.rizaldev.interactivetodolist.features.home.domain.HomeRepository

class HomeRepositoryImpl : HomeRepository {

    override fun getHomeContent(): Result<List<ContentEntity>> {
        return Result.success(
            listOf(
                ContentEntity(
                    1,
                    "Transforming Pull Request Format at DANA Indonesia",
                    "Pull Request Review is a good thing to have on every software engineering company, it helps improving team knowledge and prevent bad code from going into the main code base of a project.",
                    "https://picsum.photos/200/200",
                    "",
                    "MEDIUM"
                ),
                ContentEntity(
                    2,
                    "Android Application Components",
                    "App components are the essential building blocks of an Android app. Each component is an entry point through which the system or a user can enter your app. Some components depend on others.",
                    "https://picsum.photos/201/201",
                    "",
                    "ANDROID"
                )
            )
        )
    }
}