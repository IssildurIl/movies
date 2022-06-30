package com.iish.movies.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.iish.movies.databinding.CustomRecyclerviewLayoutBinding
import com.iish.movies.model.Cinema
import com.iish.movies.recyclerview.viewholder.CinemaViewHolder


class CinemaListAdapter(private val itemListener: ItemListener) : ListAdapter<Cinema, CinemaViewHolder>(DiffCallback()) {

    private var data: List<Cinema>? = null

    fun updData(data: List<Cinema>){
        this.data = data
    }

    override fun onBindViewHolder(holder: CinemaViewHolder, position: Int) {
        holder.bind(data!![position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CinemaViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = CustomRecyclerviewLayoutBinding.inflate(inflater, parent, false)
        return CinemaViewHolder(binding,itemListener)
    }

    private class DiffCallback : DiffUtil.ItemCallback<Cinema>() {

        override fun areItemsTheSame(oldItem: Cinema, newItem: Cinema): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Cinema, newItem: Cinema): Boolean {
            return oldItem == newItem
        }
    }

    override fun submitList(list: MutableList<Cinema>?) {
        super.submitList(list?.let { ArrayList(it) })
    }

}