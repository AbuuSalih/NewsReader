package com.xubbzz.news.splash.presentation.splash

import by.kirich1409.viewbindingdelegate.viewBinding
import com.xubbzz.news.R
import com.xubbzz.news.core.presentation.base.BaseFragment
import com.xubbzz.news.databinding.FragmentSplashBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class SplashFragment : BaseFragment(R.layout.fragment_splash) {

    override val binding by viewBinding(FragmentSplashBinding::bind)
    override val viewModel by viewModel<SplashViewModel>()

    override fun setupView() {
        viewModel.loadNews()
    }
}