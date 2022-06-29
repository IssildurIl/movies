package com.iish.movies.data.repository

import androidx.lifecycle.LiveData
import com.iish.movies.data.MoviesDatabase
import com.iish.movies.di.RetrofitServiceInterface
import com.iish.movies.model.Cinema
import javax.inject.Inject

class CinemaRepository @Inject constructor(moviesDatabase: MoviesDatabase, private val retrofitServiceInterface: RetrofitServiceInterface) {

    private val cinemaDao = moviesDatabase.cinemaDao()
    val allCinema: LiveData<List<Cinema>> = cinemaDao.getAllCinema()

    suspend fun loadData() {
        val result = retrofitServiceInterface.getData()
        val requestResult = result.body()
        if (result.isSuccessful && requestResult != null) {
            cinemaDao.addCinemas(requestResult)
        }
    }

    suspend fun addCinema(cinema: Cinema) {
        cinemaDao.addCinema(cinema)
    }

    suspend fun updateCinema(cinema: Cinema) {
        cinemaDao.updateCinema(cinema)
    }

    suspend fun deleteCinema(cinema: Cinema) {
        cinemaDao.deleteCinema(cinema)
    }
}