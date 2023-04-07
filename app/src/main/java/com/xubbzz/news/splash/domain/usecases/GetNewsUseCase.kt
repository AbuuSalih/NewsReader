package com.xubbzz.news.splash.domain.usecases

import com.xubbzz.news.news.data.api.NewsNetModel
import com.xubbzz.news.news.domain.repository.NewsRepository

class GetNewsUseCase(
    private val repository: NewsRepository
) {
    suspend fun invoke(): NewsNetModel {
        return repository.getNews()
    }
}