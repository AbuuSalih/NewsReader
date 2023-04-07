package com.xubbzz.news.news.domain.usecases

import com.xubbzz.news.news.data.room.entities.NewsPreviewTuple
import com.xubbzz.news.news.domain.repository.NewsRepository

class GetPreviewNewsUseCase(
    private val repository: NewsRepository
) {
    suspend fun invoke(): List<NewsPreviewTuple> {
        return repository.getPreviewNews()
    }
}