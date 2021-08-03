package com.rizaldev.interactivetodolist.features.home.domain

import com.rizaldev.interactivetodolist.common.base.BaseResult
import com.rizaldev.interactivetodolist.common.base.UseCase
import com.rizaldev.interactivetodolist.features.home.data.HomeRepositoryImpl
import com.rizaldev.interactivetodolist.features.home.domain.mapper.toListContent
import com.rizaldev.interactivetodolist.features.home.domain.model.Content

class GetHomeContent :
    UseCase<BaseResult<List<Content>>, GetHomeContent.NoParams>() {

    private val homeRepository = HomeRepositoryImpl()

    override suspend fun run(params: NoParams): BaseResult<List<Content>> {
        return BaseResult.Success(
            homeRepository.getHomeContent().getOrNull()?.toListContent() ?: listOf()
        )
    }

    class NoParams
}