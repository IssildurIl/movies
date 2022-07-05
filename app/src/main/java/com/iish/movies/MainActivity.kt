package com.iish.movies

import android.os.Bundle
import android.view.View
import android.view.ViewTreeObserver
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.ViewModelProvider
import com.iish.movies.databinding.ActivityMainBinding
import com.iish.movies.fragments.start.StartCinemaViewModel


class MainActivity : AppCompatActivity() {
    private lateinit var startCinemaViewModel: StartCinemaViewModel
    private lateinit var binding: ActivityMainBinding
    private var contentHasLoaded = false

    override fun onCreate(savedInstanceState: Bundle?) {
        val splashScreen = installSplashScreen()
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        startCinemaViewModel = ViewModelProvider(this)[StartCinemaViewModel::class.java]
        setContentView(binding.root)
        initViewModel()
        setupSplashScreen(splashScreen)
    }

    private fun initViewModel() {
        startCinemaViewModel.response.observe(this) {
            contentHasLoaded = true
        }
    }

    private fun setupSplashScreen(splashScreen: SplashScreen) {
        val content: View = findViewById(android.R.id.content)
        content.viewTreeObserver.addOnPreDrawListener(
            object : ViewTreeObserver.OnPreDrawListener {
                override fun onPreDraw(): Boolean {
                    return if (contentHasLoaded) {
                        content.viewTreeObserver.removeOnPreDrawListener(this)
                        true
                    } else false
                }
            }
        )
    }


}