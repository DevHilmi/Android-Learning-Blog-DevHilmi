package com.rizaldev.interactivetodolist.features.home.domain

import com.rizaldev.interactivetodolist.common.base.UseCase
import com.rizaldev.interactivetodolist.features.home.domain.mapper.toListContent
import com.rizaldev.interactivetodolist.features.home.domain.model.Content
import javax.inject.Inject

class GetHomeContent @Inject constructor(private val homeRepository: HomeRepository) :
    UseCase<List<Content>, Unit>() {

    override suspend fun run(params: Unit): List<Content> {
        return homeRepository.getHomeContent().getOrNull()?.toListContent() ?: listOf()
    }

}