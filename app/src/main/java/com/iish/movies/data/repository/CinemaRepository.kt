package com.iish.movies.data.repository

import androidx.lifecycle.LiveData
import com.iish.movies.data.dao.CinemaDao
import com.iish.movies.model.Cinema

class CinemaRepository(private val cinemaDao: CinemaDao) {

    val readAllCinema: LiveData<List<Cinema>> = cinemaDao.getAllCinema()

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