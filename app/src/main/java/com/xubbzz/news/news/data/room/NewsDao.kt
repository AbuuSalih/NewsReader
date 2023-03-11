package com.xubbzz.news.news.data.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.xubbzz.news.news.data.room.entities.NewsDbEntity
import com.xubbzz.news.news.data.room.entities.NewsDetailTuple
import com.xubbzz.news.news.data.room.entities.NewsPreviewTuple

@Dao
interface NewsDao {

    @Query(value = "SELECT * FROM news")
    suspend fun getPreviewNews(): List<NewsPreviewTuple>

    @Query(value = "SELECT title, url_to_image, content, published_at FROM news WHERE title = :title")
    suspend fun getDetailNews(title: String): NewsDetailTuple

    @Insert(entity = NewsDbEntity::class, onConflict = OnConflictStrategy.IGNORE)
    suspend fun addNews(news: NewsDbEntity)
}