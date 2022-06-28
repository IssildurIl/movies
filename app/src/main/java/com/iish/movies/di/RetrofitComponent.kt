package com.iish.movies.di

import com.iish.movies.viewmodel.MainActivityViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [RetrofitModule::class])
interface RetrofitComponent {

    fun inject(mainActivityViewModel: MainActivityViewModel)

}