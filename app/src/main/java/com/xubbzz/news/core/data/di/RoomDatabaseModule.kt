package com.xubbzz.news.core.data.di

import androidx.room.Room
import com.xubbzz.news.core.data.room.AppDatabase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

fun roomDatabaseModule() = module {
    single {
        Room.databaseBuilder(
            androidApplication(),
            AppDatabase::class.java,
            "news"
        ).build()
    }
}