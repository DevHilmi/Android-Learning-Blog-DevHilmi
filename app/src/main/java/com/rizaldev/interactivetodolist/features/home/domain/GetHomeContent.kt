package com.rizaldev.interactivetodolist.features.home.domain

import com.rizaldev.interactivetodolist.common.base.BaseResult
import com.rizaldev.interactivetodolist.common.base.UseCase
import com.rizaldev.interactivetodolist.features.home.domain.mapper.toListContent
import com.rizaldev.interactivetodolist.features.home.domain.model.Content
import javax.inject.Inject

class GetHomeContent @Inject constructor(private val homeRepository: HomeRepository) :
    UseCase<BaseResult<List<Content>>, Unit>() {

    override suspend fun run(params: Unit): BaseResult<List<Content>> {
        return BaseResult.Success(
            homeRepository.getHomeContent().getOrNull()?.toListContent() ?: listOf()
        )
    }

}