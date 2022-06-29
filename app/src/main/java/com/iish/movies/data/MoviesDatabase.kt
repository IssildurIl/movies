package com.iish.movies.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.iish.movies.data.dao.CinemaDao
import com.iish.movies.model.Cinema

@Database(entities = [Cinema::class], version = 1, exportSchema = true)
abstract class MoviesDatabase : RoomDatabase() {

    abstract fun cinemaDao(): CinemaDao
}