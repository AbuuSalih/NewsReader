package com.xubbzz.news.news.domain

import com.xubbzz.news.news.domain.usecases.GetDetailNewsUseCase
import com.xubbzz.news.news.domain.usecases.GetPreviewNewsUseCase
import org.koin.dsl.module

fun newsDomainModule() = module {
    factory { GetDetailNewsUseCase(get()) }
    factory { GetPreviewNewsUseCase(get()) }
}