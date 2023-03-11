package com.xubbzz.news.news.data.api

import com.xubbzz.news.news.data.room.model.NewsModel

data class NewsNetModel(
    val status: String,
    val totalResults: Int,
    val articles: List<NewsModel>
)