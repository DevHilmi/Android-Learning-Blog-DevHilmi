package com.rizaldev.interactivetodolist.features.home.domain

import com.rizaldev.interactivetodolist.common.base.BaseResult
import com.rizaldev.interactivetodolist.common.base.UseCase
import com.rizaldev.interactivetodolist.features.home.domain.model.Content

class GetHomeContent : UseCase<BaseResult<List<Content>>, GetHomeContent.NoParams>() {

    override suspend fun run(params: NoParams): BaseResult<List<Content>> {
        return BaseResult.Success(
            listOf(
                Content("a", "Result From Domain Layer", "c", "d"),
                Content("a", "b", "c", "d")
            )
        )
    }

    class NoParams
}