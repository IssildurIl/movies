package com.iish.movies.di

import com.iish.movies.model.Cinema
import com.iish.movies.model.CinemaList
import retrofit2.Response
import retrofit2.http.GET

interface RetrofitServiceInterface {

    @GET("shows")
    suspend fun getData(): Response<List<Cinema>>

}