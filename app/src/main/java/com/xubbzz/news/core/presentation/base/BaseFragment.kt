package com.xubbzz.news.core.presentation.base

import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.viewbinding.ViewBinding

abstract class BaseFragment(@LayoutRes layout: Int) : Fragment(layout) {

    abstract val binding: ViewBinding
    abstract val viewModel: ViewModel

    abstract fun setupView()
    open fun setupViewModel() { }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setupView()
        setupViewModel()
    }
}