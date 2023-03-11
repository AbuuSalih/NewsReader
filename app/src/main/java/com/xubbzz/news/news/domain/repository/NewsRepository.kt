package com.xubbzz.news.news.domain.repository

import com.xubbzz.news.news.data.api.NewsNetModel
import com.xubbzz.news.news.data.room.entities.NewsDbEntity
import com.xubbzz.news.news.data.room.entities.NewsDetailTuple
import com.xubbzz.news.news.data.room.entities.NewsPreviewTuple

interface NewsRepository {

    suspend fun getNews(): NewsNetModel

    suspend fun getPreviewNews(): List<NewsPreviewTuple>

    suspend fun getDetailNews(title: String): NewsDetailTuple

    suspend fun addNews(newsDbEntity: NewsDbEntity)
}