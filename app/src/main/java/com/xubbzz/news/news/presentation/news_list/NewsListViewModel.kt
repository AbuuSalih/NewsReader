package com.xubbzz.news.news.presentation.news_list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.xubbzz.news.core.presentation.navigation.Screens
import com.xubbzz.news.news.data.room.entities.NewsPreviewTuple
import com.xubbzz.news.news.domain.usecases.GetPreviewNewsUseCase
import kotlinx.coroutines.launch
import me.aartikov.alligator.AndroidNavigator

class NewsListViewModel(
    private val getPreviewNewsUseCase: GetPreviewNewsUseCase,
    private val navigator: AndroidNavigator
) : ViewModel() {

    private val _content = MutableLiveData<List<NewsPreviewTuple>>()
    val content: LiveData<List<NewsPreviewTuple>> get() = _content

    private val newsList by lazy { mutableListOf<NewsPreviewTuple>() }

    init {
        viewModelScope.launch {
            newsList.addAll(getPreviewNewsUseCase.invoke())
            bindContent(newsList)
        }
    }

    fun onNewsClicked(news: NewsPreviewTuple) {
        navigator.goForward(Screens.NewsDetail(news.title))
    }

    fun searchNews(search: String) {
        if (search.isBlank()) bindContent()
        else {
            _content.value = newsList.filter { news ->
                news.title.contains(search, ignoreCase = true)
                        || news.description.contains(search, ignoreCase = true)
                        || news.content?.contains(search, ignoreCase = true) ?: false
            }
        }
    }

    private fun bindContent(news: List<NewsPreviewTuple> = newsList) {
        _content.value = news
    }
}