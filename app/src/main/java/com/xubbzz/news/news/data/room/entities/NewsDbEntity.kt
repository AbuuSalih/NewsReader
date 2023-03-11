package com.xubbzz.news.news.data.room.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.xubbzz.news.news.data.room.model.NewsModel

@Entity(tableName = "news")
data class NewsDbEntity(
    @PrimaryKey @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "description") val description: String,
    @ColumnInfo(name = "published_at") val publishedAt: String,
    @ColumnInfo(name = "url_to_image") val urlToImage: String?,
    @ColumnInfo(name = "content") val content: String?
)

fun NewsDbEntity.toNewsModel() = NewsModel(
    title = title,
    description = description,
    publishedAt = publishedAt,
    urlToImage = urlToImage,
    content = content
)
