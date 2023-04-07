package com.xubbzz.news.news.presentation

import com.xubbzz.news.news.presentation.news_detail.NewsDetailViewModel
import com.xubbzz.news.news.presentation.news_list.NewsListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

fun newsPresentationModule() = module {
    viewModel {
        NewsListViewModel(
            getPreviewNewsUseCase = get(),
            navigator = get()
        )
    }
    viewModel {
        NewsDetailViewModel(
            args = get(),
            getDetailNewsUseCase = get()
        )
    }
}