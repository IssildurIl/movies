package com.iish.movies.recyclerview.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.iish.movies.databinding.CustomRecyclerviewLayoutBinding
import com.iish.movies.model.Cinema
import com.iish.movies.recyclerview.ItemListener

class CinemaViewHolder(private val binding: CustomRecyclerviewLayoutBinding, itemListener: ItemListener) :
    RecyclerView.ViewHolder(binding.root) {

    init {
        binding.root.setOnClickListener {
            itemListener.onClick(adapterPosition)
        }
    }

    fun bind(cinema: Cinema) {
        Glide.with(binding.root)
            .load(cinema.image.original)
            .transform(RoundedCorners(25))
            .into(binding.movieImg)
        binding.movieName.text = cinema.name
    }
}