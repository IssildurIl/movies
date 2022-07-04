package com.iish.movies.di

import android.content.Context
import com.iish.movies.data.repository.CinemaRepository
import com.iish.movies.di.modules.DataBaseModule
import com.iish.movies.di.modules.RetrofitModule
import com.iish.movies.fragments.start_fragment.StartCinemaViewModel
import com.iish.movies.viewmodel.MainActivityViewModel
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [RetrofitModule::class, DataBaseModule::class])
interface AppComponent {

    fun inject(mainActivityViewModel: MainActivityViewModel)

    fun inject(cinemaRepository: CinemaRepository)

    fun inject(startCinemaViewModel: StartCinemaViewModel)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun context(context: Context): Builder
        fun retrofitModule(retrofitModule: RetrofitModule):Builder
        fun databaseModule(dataBaseModule: DataBaseModule):Builder
        fun build(): AppComponent
    }


}