package com.xubbzz.news.splash.presentation

import com.xubbzz.news.splash.presentation.splash.SplashViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

fun splashPresentationModule() = module {
    viewModel {
        SplashViewModel(
            navigator = get(),
            getNewsUseCase = get(),
            addNewsUseCase = get()
        )
    }
}