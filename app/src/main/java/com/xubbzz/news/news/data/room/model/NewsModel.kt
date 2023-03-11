package com.xubbzz.news.news.data.room.model

import com.xubbzz.news.news.data.room.entities.NewsDbEntity

data class NewsModel(
    val title: String,
    val description: String,
    val publishedAt: String,
    val urlToImage: String?,
    val content: String?
)

fun NewsModel.toDatabase() = NewsDbEntity(
    title = title,
    description = description,
    publishedAt = publishedAt,
    urlToImage = urlToImage,
    content = content
)
