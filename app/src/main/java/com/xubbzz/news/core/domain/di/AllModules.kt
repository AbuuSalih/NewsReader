package com.xubbzz.news.core.domain.di

import com.xubbzz.news.core.data.di.networkModule
import com.xubbzz.news.core.data.di.roomDatabaseModule
import com.xubbzz.news.core.presentation.di.navigationModule
import com.xubbzz.news.news.data.newsDataModule
import com.xubbzz.news.news.domain.newsDomainModule
import com.xubbzz.news.news.presentation.newsPresentationModule
import com.xubbzz.news.splash.domain.splashDomainModule
import com.xubbzz.news.splash.presentation.splashPresentationModule

fun allModules() = listOf(
    networkModule(),
    navigationModule(),
    roomDatabaseModule(),

    splashDomainModule(),
    splashPresentationModule(),

    newsDataModule(),
    newsDomainModule(),
    newsPresentationModule()
)