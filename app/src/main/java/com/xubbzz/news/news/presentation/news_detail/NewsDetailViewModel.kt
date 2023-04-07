package com.xubbzz.news.news.presentation.news_detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.xubbzz.news.core.presentation.navigation.Screens
import com.xubbzz.news.news.domain.usecases.GetDetailNewsUseCase
import kotlinx.coroutines.launch

class NewsDetailViewModel(
    private val args: Screens.NewsDetail,
    private val getDetailNewsUseCase: GetDetailNewsUseCase
) : ViewModel() {

    private val _content = MutableLiveData<HashMap<String, String?>>()
    val content: LiveData<HashMap<String, String?>> get() = _content

    private val elementsNews = HashMap<String, String?>()

    init {
        viewModelScope.launch {
            val news = getDetailNewsUseCase.invoke(args.keyTitle)
            elementsNews[NewsDetail.TITLE.name] = news.title
            elementsNews[NewsDetail.CONTENT.name] = news.content
            elementsNews[NewsDetail.IMAGE.name] = news.urlToImage
            elementsNews[NewsDetail.DATE_PUBLICATION.name] = news.publishedAt

            bindContent(elementsNews)
        }
    }

    private fun bindContent(news: HashMap<String, String?> = elementsNews) {
        _content.value = news
    }

    enum class NewsDetail {
        TITLE,
        CONTENT,
        IMAGE,
        DATE_PUBLICATION
    }

}