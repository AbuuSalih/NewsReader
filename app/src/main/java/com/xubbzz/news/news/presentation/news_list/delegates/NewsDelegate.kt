package com.xubbzz.news.news.presentation.news_list.delegates

import androidx.core.view.isVisible
import com.bumptech.glide.Glide
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding
import com.xubbzz.news.databinding.ItemNewsPreviewBinding
import com.xubbzz.news.news.data.room.entities.NewsPreviewTuple

fun newsDelegate(
    onItemClickListener: (NewsPreviewTuple) -> Unit
) = adapterDelegateViewBinding<NewsPreviewTuple, NewsPreviewTuple, ItemNewsPreviewBinding>(
    viewBinding = { layoutInflater, parent ->
        ItemNewsPreviewBinding.inflate(layoutInflater, parent, false)
    }
) {

    with(binding) {

        root.setOnClickListener { onItemClickListener.invoke(item) }

        bind {
            titleNewsPreviewText.text = item.title
            descriptionNewsPreviewText.text = item.description

            if (item.urlToImage == null) {
                imageNewsPreviewImage.isVisible = false
            } else {
                Glide
                    .with(context)
                    .load(item.urlToImage)
                    .centerCrop()
                    .into(imageNewsPreviewImage)
            }

            publishedAtNewsPreviewText.text = "Published at: ${item.publishedAt}"
        }
    }
}