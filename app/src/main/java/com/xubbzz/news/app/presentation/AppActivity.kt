package com.xubbzz.news.app.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import com.xubbzz.news.R
import com.xubbzz.news.core.presentation.navigation.GlobalNavigator
import com.xubbzz.news.databinding.ActivityAppBinding
import com.xubbzz.news.splash.presentation.splash.SplashFragment
import me.aartikov.alligator.NavigationContext

class AppActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAppBinding
    private val navigator = GlobalNavigator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAppBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupView(savedInstanceState)
    }

    private fun setupView(savedInstanceState: Bundle?): Unit = with(binding) {
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(fragmentAppContainer.id, SplashFragment())
                .commit()
        }

        onBackPressedDispatcher.addCallback(
            this@AppActivity,
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    navigator.goBack()
                }
            })
    }

    override fun onResume() {
        super.onResume()
        val navigationContext = NavigationContext.Builder(this, navigator.navigationFactory)
            .fragmentNavigation(supportFragmentManager, R.id.fragment_app_container)
            .build()
        navigator.bind(navigationContext)
    }

    override fun onPause() {
        navigator.unbind(this)
        super.onPause()
    }
}