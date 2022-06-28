package com.iish.movies.app

import android.app.Application
import com.iish.movies.di.DaggerRetrofitComponent
import com.iish.movies.di.RetrofitComponent
import com.iish.movies.di.RetrofitModule

class App : Application() {

    private lateinit var retrofitComponent: RetrofitComponent

    override fun onCreate() {
        super.onCreate()
        retrofitComponent = DaggerRetrofitComponent.builder()
            .retrofitModule(RetrofitModule())
            .build()
    }

    fun getRetrofitComponent():RetrofitComponent{
        return retrofitComponent
    }
}