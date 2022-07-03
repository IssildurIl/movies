package com.iish.movies.di

import com.iish.movies.model.Cinema
import com.iish.movies.utils.Constants
import retrofit2.Response
import retrofit2.http.GET

interface RetrofitServiceInterface {

    @GET(Constants.URL_FINAL)
    suspend fun getData(): Response<List<Cinema>>

}