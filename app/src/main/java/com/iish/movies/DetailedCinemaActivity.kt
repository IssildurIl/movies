package com.iish.movies

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.CenterInside
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.iish.movies.databinding.ActivityDetailedCinemaBinding
import com.iish.movies.model.Cinema
import java.io.Serializable

class DetailedCinemaActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailedCinemaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailedCinemaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val args = intent.extras
        val cinema:Cinema = args?.getSerializable("cinema") as Cinema
        setData(cinema)
    }

    private fun setData(cinema: Cinema){
        binding.movieTitle.text = cinema.name
        binding.movieDesc.text = cinema.summary
        Glide.with(binding.root)
            .load(cinema.image.medium)
            .transform(CenterInside())
            .into(binding.movieImg)
    }
}