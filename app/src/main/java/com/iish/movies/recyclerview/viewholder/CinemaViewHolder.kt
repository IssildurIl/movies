package com.iish.movies.recyclerview.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.iish.movies.databinding.CustomRecyclerviewLayoutBinding
import com.iish.movies.model.Cinema

class CinemaViewHolder(private val binding: CustomRecyclerviewLayoutBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(cinema: Cinema) {
        Glide.with(binding.root)
            .load(cinema.image.original)
            .into(binding.movieImg)
        binding.movieTitle.text = cinema.name
        binding.movieDesc.text = cinema.summary
    }
}