package com.xubbzz.news.news.presentation.news_list

import androidx.core.widget.doAfterTextChanged
import androidx.recyclerview.widget.DiffUtil
import by.kirich1409.viewbindingdelegate.viewBinding
import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter
import com.xubbzz.news.R
import com.xubbzz.news.core.presentation.base.BaseFragment
import com.xubbzz.news.core.presentation.util.SpaceItemDecoration
import com.xubbzz.news.core.presentation.util.toDpInt
import com.xubbzz.news.databinding.FragmentNewsListBinding
import com.xubbzz.news.news.data.room.entities.NewsPreviewTuple
import com.xubbzz.news.news.presentation.news_list.delegates.newsDelegate
import org.koin.androidx.viewmodel.ext.android.viewModel

class NewsListFragment : BaseFragment(R.layout.fragment_news_list) {

    override val binding by viewBinding(FragmentNewsListBinding::bind)
    override val viewModel by viewModel<NewsListViewModel>()

    private val newsAdapter by lazy {
        AsyncListDifferDelegationAdapter(
            object : DiffUtil.ItemCallback<NewsPreviewTuple>() {
                override fun areItemsTheSame(oldItem: NewsPreviewTuple, newItem: NewsPreviewTuple): Boolean {
                    return oldItem.title == newItem.title
                }

                override fun areContentsTheSame(oldItem: NewsPreviewTuple, newItem: NewsPreviewTuple): Boolean {
                    return oldItem == newItem
                }
            },
            newsDelegate(
                onItemClickListener = { viewModel.onNewsClicked(it) }
            )
        )
    }

    override fun setupView(): Unit = with(binding) {
        newsListNewsListScrolling.apply {
            adapter = newsAdapter
            addItemDecoration(SpaceItemDecoration(8.toDpInt()))
        }
        searchNewsListText.doAfterTextChanged {
            viewModel.searchNews(searchNewsListText.text.toString())
        }
    }

    override fun setupViewModel(): Unit = with(viewModel) {
        content.observe(viewLifecycleOwner) { onContentChange(it) }
    }

    private fun onContentChange(newsList: List<NewsPreviewTuple>): Unit = with(binding) {
        newsListNewsListScrolling.scrollToPosition(0)
        newsAdapter.items = newsList
    }
}