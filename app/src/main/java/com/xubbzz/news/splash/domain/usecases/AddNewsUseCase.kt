package com.xubbzz.news.splash.domain.usecases

import com.xubbzz.news.news.data.room.entities.NewsDbEntity
import com.xubbzz.news.news.domain.repository.NewsRepository

class AddNewsUseCase(
    private val repository: NewsRepository
) {
    suspend fun invoke(newsDbEntity: NewsDbEntity) {
        repository.addNews(newsDbEntity)
    }
}