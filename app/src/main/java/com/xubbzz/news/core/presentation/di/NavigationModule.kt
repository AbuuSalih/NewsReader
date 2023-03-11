package com.xubbzz.news.core.presentation.di

import com.xubbzz.news.core.presentation.navigation.GlobalNavigator
import me.aartikov.alligator.AndroidNavigator
import org.koin.dsl.bind
import org.koin.dsl.module

fun navigationModule() = module {
    single { GlobalNavigator } bind AndroidNavigator::class
    single { get<AndroidNavigator>().screenResolver }
}