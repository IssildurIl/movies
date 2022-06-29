package com.iish.movies.app

import android.app.Application
import com.iish.movies.di.AppComponent
import com.iish.movies.di.DaggerAppComponent
import com.iish.movies.di.modules.DataBaseModule
import com.iish.movies.di.modules.RetrofitModule

class App : Application() {

    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .context(context = this)
            .retrofitModule(RetrofitModule())
            .databaseModule(DataBaseModule())
            .build()
    }

    fun getRetrofitComponent(): AppComponent {
        return appComponent
    }
}