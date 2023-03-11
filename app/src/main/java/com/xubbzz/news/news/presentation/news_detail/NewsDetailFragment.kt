package com.xubbzz.news.news.presentation.news_detail

import androidx.core.view.isVisible
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.Glide
import com.xubbzz.news.R
import com.xubbzz.news.core.presentation.base.BaseFragment
import com.xubbzz.news.core.presentation.navigation.Screens
import com.xubbzz.news.databinding.FragmentNewsDetailBinding
import com.xubbzz.news.news.presentation.news_detail.NewsDetailViewModel.*
import me.aartikov.alligator.ScreenResolver
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class NewsDetailFragment : BaseFragment(R.layout.fragment_news_detail) {

    private val screenResolver: ScreenResolver by inject()
    private val screenArg: Screens.NewsDetail by lazy {
        screenResolver.getScreen(this)
    }

    override val binding by viewBinding(FragmentNewsDetailBinding::bind)
    override val viewModel by viewModel<NewsDetailViewModel>(
        parameters = { parametersOf(screenArg) }
    )

    override fun setupView(): Unit = with(binding) {

    }

    override fun setupViewModel(): Unit = with(viewModel) {
        content.observe(viewLifecycleOwner) { onContentChange(it) }
    }

    private fun onContentChange(newsDetail: HashMap<String, String?>?): Unit = with(binding) {
        titleNewsDetailText.text = newsDetail?.get(NewsDetail.TITLE.name)
        publishedAtNewsDetailText.text =
            "Published at: ${newsDetail?.get(NewsDetail.DATE_PUBLICATION.name)}"

        if (newsDetail?.get(NewsDetail.IMAGE.name) == null) {
            imageNewsDetailImage.isVisible = false
        } else {
           Glide
                .with(this@NewsDetailFragment)
                .load(newsDetail[NewsDetail.IMAGE.name])
                .into(imageNewsDetailImage)
        }
        contentNewsDetailText.text = newsDetail?.get(NewsDetail.CONTENT.name)
    }
}