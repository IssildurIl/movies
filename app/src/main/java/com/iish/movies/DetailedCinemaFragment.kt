package com.iish.movies

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterInside
import com.iish.movies.databinding.FragmentDetailedCinemaBinding
import com.iish.movies.model.Cinema

class DetailedCinemaFragment : Fragment() {

    private lateinit var binding: FragmentDetailedCinemaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailedCinemaBinding.inflate(layoutInflater)
        return binding.root
    }

    private fun setData(cinema: Cinema) {
        binding.movieTitle.text = cinema.name
        binding.movieDesc.text = cinema.summary
        Glide.with(binding.root)
            .load(cinema.image.medium)
            .transform(CenterInside())
            .into(binding.movieImg)
    }

}