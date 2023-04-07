package com.xubbzz.news.splash.presentation.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.xubbzz.news.core.presentation.navigation.Screens
import com.xubbzz.news.news.data.room.model.NewsModel
import com.xubbzz.news.news.data.room.model.toDatabase
import com.xubbzz.news.splash.domain.usecases.AddNewsUseCase
import com.xubbzz.news.splash.domain.usecases.GetNewsUseCase
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import me.aartikov.alligator.AndroidNavigator

class SplashViewModel(
    private val navigator: AndroidNavigator,
    private val getNewsUseCase: GetNewsUseCase,
    private val addNewsUseCase: AddNewsUseCase
) : ViewModel() {

    fun loadNews() {
        viewModelScope.launch {
            val ounerScope = this@launch
            try {
                val timer = launch {
                    delay(3000)
                    ounerScope.cancel()
                }
                val response = launch {
                    getNewsUseCase.invoke().articles
                        .map(NewsModel::toDatabase)
                        .forEach { addNewsUseCase.invoke(it) }
                    ounerScope.cancel()
                }
                timer.join()
                response.join()
            } catch (e: Exception) {
                e.printStackTrace()
            } finally {
                navigator.replace(Screens.NewsList)
            }
        }
    }
}