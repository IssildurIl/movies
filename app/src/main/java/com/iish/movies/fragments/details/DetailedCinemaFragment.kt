package com.iish.movies.fragments.details

import android.os.Bundle
import android.text.Html
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.CenterInside
import com.iish.movies.R
import com.iish.movies.databinding.FragmentDetailedCinemaBinding
import com.iish.movies.model.Cinema

class DetailedCinemaFragment : Fragment() {

    private val args by navArgs<DetailedCinemaFragmentArgs>()

    private lateinit var binding: FragmentDetailedCinemaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.navigation, menu)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailedCinemaBinding.inflate(layoutInflater)
        setData(args.currentCinema)
        return binding.root
    }

    private fun setData(cinema: Cinema) {
//        binding.movieTitle.text = cinema.name
        binding.movieDesc.text =  Html.fromHtml(cinema.summary).toString()
        Glide.with(binding.root)
            .load(cinema.image.original)
            .transform(CenterCrop())
            .into(binding.movieImg)
    }

}