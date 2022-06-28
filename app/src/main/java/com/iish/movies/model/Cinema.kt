package com.iish.movies.model

import com.google.gson.annotations.SerializedName

data class Cinema(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    val image: Image,
    @SerializedName("summary")
    val summary: String
)

data class CinemaList(
    val imageList: List<Cinema>
)