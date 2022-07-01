package com.iish.movies

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.ViewTreeObserver
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.iish.movies.databinding.ActivityMainBinding
import com.iish.movies.recyclerview.CinemaListAdapter
import com.iish.movies.recyclerview.ItemListener
import com.iish.movies.recyclerview.decorators.CustomItemDecorator
import com.iish.movies.viewmodel.MainActivityViewModel


open class MainActivity : AppCompatActivity(), ItemListener {
    private lateinit var binding: ActivityMainBinding
    private var cinemaAdapter: CinemaListAdapter = CinemaListAdapter(this)
    private lateinit var mainActivityViewModel: MainActivityViewModel
    private var contentHasLoaded = false
    private var customItemDecorator: CustomItemDecorator = CustomItemDecorator()

    override fun onCreate(savedInstanceState: Bundle?) {
        val splashScreen = installSplashScreen()
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        mainActivityViewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        initRecyclerView()
        initViewModel()
        initToolBar()
        setupSplashScreen(splashScreen)
    }

    private fun initToolBar() {
        setSupportActionBar(binding.toolbar)
        binding.searchView.setOnQueryTextListener(object : androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                mainActivityViewModel.findCinemaByName(query!!)
                mainActivityViewModel.findedCinema?.observe(this@MainActivity) { cinemaList ->
                    cinemaAdapter.updData(cinemaList)
                    cinemaAdapter.submitList(cinemaList.toMutableList())
                    contentHasLoaded = true
                }
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }
        })
        binding.searchView.setOnCloseListener {
            mainActivityViewModel.response.observe(this@MainActivity) { cinemaList ->
                cinemaAdapter.updData(cinemaList)
                cinemaAdapter.submitList(cinemaList.toMutableList())
                contentHasLoaded = true
            }
            false
        }
    }


    private fun initRecyclerView() {
        binding.recyclerView.apply {
            adapter = cinemaAdapter
            layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.HORIZONTAL, false)
            customItemDecorator.recyclerDecoration(10, 10)
            addItemDecoration(customItemDecorator)
        }

    }

    private fun initViewModel() {
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

    override fun onClick(position: Int) {
        cinemaAdapter.currentList[position]?.let {
            val intent = Intent(this, DetailedCinemaActivity::class.java)
            intent.putExtra("cinema", it)
            startActivity(intent)
        }
    }

}