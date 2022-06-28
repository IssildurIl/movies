package com.iish.movies.recyclerview

interface ItemListener {

    fun onClick(position: Int)

    fun onItemCheckedChange(position: Int, checked: Boolean)
}