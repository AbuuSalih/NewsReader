package com.xubbzz.news.news.domain.usecases

import com.xubbzz.news.news.data.room.entities.NewsDetailTuple
import com.xubbzz.news.news.domain.repository.NewsRepository

class GetDetailNewsUseCase(
    private val repository: NewsRepository
) {
    suspend fun invoke(title: String): NewsDetailTuple {
        return repository.getDetailNews(title)
    }
}