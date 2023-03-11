package com.xubbzz.news.splash

import com.xubbzz.news.splash.presentation.SplashViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

fun splashPresentationModule() = module {
    viewModel {
        SplashViewModel(
            newsRepository = get(),
            navigator = get()
        )
    }
}