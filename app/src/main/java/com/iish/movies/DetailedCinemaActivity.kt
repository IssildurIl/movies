package com.iish.movies

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.iish.movies.databinding.ActivityDetailedCinemaBinding

class DetailedCinemaActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailedCinemaBinding

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        binding = ActivityDetailedCinemaBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}