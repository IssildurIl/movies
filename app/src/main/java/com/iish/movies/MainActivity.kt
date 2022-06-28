package com.iish.movies

import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewTreeObserver
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.iish.movies.databinding.ActivityMainBinding
import com.iish.movies.model.Cinema
import com.iish.movies.model.Image
import com.iish.movies.recyclerview.CinemaListAdapter
import com.iish.movies.viewmodel.MainActivityViewModel


open class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var cinemaAdapter: CinemaListAdapter = CinemaListAdapter()
    private lateinit var mainActivityViewModel: MainActivityViewModel
    var contentHasLoaded = false

    override fun onCreate(savedInstanceState: Bundle?) {
        val splashScreen = installSplashScreen()
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecyclerView()
        initViewModel()

        setupSplashScreen(splashScreen)
    }


    private fun initRecyclerView() {
        binding.recyclerView.apply {
            adapter = cinemaAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
        }
    }

    private fun initViewModel() {
        mainActivityViewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        mainActivityViewModel.response.observe(this) { cinemaList ->
            cinemaAdapter.updData(cinemaList)
            cinemaAdapter.submitList(cinemaList.toMutableList())
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