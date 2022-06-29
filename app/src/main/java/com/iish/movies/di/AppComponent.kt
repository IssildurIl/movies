package com.iish.movies.di

import com.iish.movies.di.modules.RetrofitModule
import com.iish.movies.viewmodel.MainActivityViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [RetrofitModule::class])
interface AppComponent {

    fun inject(mainActivityViewModel: MainActivityViewModel)

}