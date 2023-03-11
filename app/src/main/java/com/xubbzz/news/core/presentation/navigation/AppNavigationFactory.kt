package com.xubbzz.news.core.presentation.navigation

import com.xubbzz.news.app.presentation.AppActivity
import com.xubbzz.news.news.presentation.news_detail.NewsDetailFragment
import com.xubbzz.news.news.presentation.news_list.NewsListFragment
import com.xubbzz.news.splash.presentation.SplashFragment
import me.aartikov.alligator.Screen
import me.aartikov.alligator.navigationfactories.RegistryNavigationFactory
import java.io.Serializable

sealed class Screens : Screen, Serializable {
    object Activity : Screens()

    object Splash : Screens()
    object NewsList : Screens()
    data class NewsDetail(val keyTitle: String) : Screens()
}

class AppNavigationFactory : RegistryNavigationFactory() {
    init {
        registerActivity(Screens.Activity::class.java, AppActivity::class.java)

        registerFragment(Screens.Splash::class.java, SplashFragment::class.java)
        registerFragment(Screens.NewsList::class.java, NewsListFragment::class.java)
        registerFragment(Screens.NewsDetail::class.java, NewsDetailFragment::class.java)
    }
}