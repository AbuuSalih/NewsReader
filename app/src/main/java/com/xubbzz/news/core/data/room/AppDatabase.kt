package com.xubbzz.news.core.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.xubbzz.news.news.data.room.NewsDao
import com.xubbzz.news.news.data.room.entities.NewsDbEntity

@Database(
    version = 1,
    entities = [
        NewsDbEntity::class
    ]
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getNewsDao(): NewsDao
}