package com.xubbzz.news.splash.domain

import com.xubbzz.news.splash.domain.usecases.AddNewsUseCase
import com.xubbzz.news.splash.domain.usecases.GetNewsUseCase
import org.koin.dsl.module

fun splashDomainModule() = module {
    factory { AddNewsUseCase(get()) }
    factory { GetNewsUseCase(get()) }
}