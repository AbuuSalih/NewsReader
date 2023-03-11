package com.xubbzz.news.news.data

import com.xubbzz.news.core.data.room.AppDatabase
import com.xubbzz.news.news.data.repository.NewsRepositoryImpl
import com.xubbzz.news.news.data.room.NewsDao
import com.xubbzz.news.news.domain.repository.NewsRepository
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

fun newsDataModule() = module {

    singleOf(::NewsRepositoryImpl) bind NewsRepository::class
    single<NewsDao> { get<AppDatabase>().getNewsDao() }
}