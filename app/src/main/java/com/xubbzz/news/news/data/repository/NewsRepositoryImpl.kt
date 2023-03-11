package com.xubbzz.news.news.data.repository

import com.xubbzz.news.news.data.api.NewsApi
import com.xubbzz.news.news.data.api.NewsNetModel
import com.xubbzz.news.news.data.room.NewsDao
import com.xubbzz.news.news.data.room.entities.NewsDbEntity
import com.xubbzz.news.news.data.room.entities.NewsDetailTuple
import com.xubbzz.news.news.data.room.entities.NewsPreviewTuple
import com.xubbzz.news.news.domain.repository.NewsRepository
import kotlinx.coroutines.Dispatchers

class NewsRepositoryImpl(
    private val newsApi: NewsApi,
    private val newsDao: NewsDao
) : NewsRepository {

    private val ioDispatcher = Dispatchers.IO

    override suspend fun getNews(): NewsNetModel = with(ioDispatcher) {
        return newsApi.getNews()
    }

    override suspend fun getPreviewNews(): List<NewsPreviewTuple> = with(ioDispatcher) {
        return newsDao.getPreviewNews()
    }

    override suspend fun getDetailNews(title: String): NewsDetailTuple = with(ioDispatcher) {
        return newsDao.getDetailNews(title)
    }

    override suspend fun addNews(newsDbEntity: NewsDbEntity): Unit = with(ioDispatcher) {
        newsDao.addNews(newsDbEntity)
    }
}