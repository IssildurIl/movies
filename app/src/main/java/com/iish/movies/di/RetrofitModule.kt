package com.iish.movies.di

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class RetrofitModule {

//    private val baseUrl = "https://api.github.com/search/"

    private val baseUrl = "https://api.tvmaze.com/" // shows

    @Provides
    @Singleton
    fun getRetrofitServiceInterface(retrofit: Retrofit):RetrofitServiceInterface{
        return retrofit.create(RetrofitServiceInterface::class.java)
    }

    @Provides
    @Singleton
    fun getRetrofitInstance(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}