package com.iish.movies.di.modules

import android.content.Context
import androidx.room.Room
import com.iish.movies.data.MoviesDatabase
import com.iish.movies.data.dao.CinemaDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataBaseModule {

    @Provides
    @Singleton
    fun getDB(moviesDatabase: MoviesDatabase): CinemaDao {
        return moviesDatabase.cinemaDao()
    }

    @Provides
    @Singleton
    fun provideMovieDB(context: Context): MoviesDatabase {
        return Room.databaseBuilder(
            context.applicationContext,
            MoviesDatabase::class.java,
            "movies_database"
        ).build()
    }

}