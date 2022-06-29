package com.iish.movies.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.iish.movies.model.Cinema

@Dao
interface CinemaDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addCinema(cinema: Cinema)

    @Update
    suspend fun updateCinema(cinema: Cinema)

    @Query("Select * from Cinema Order by id asc")
    fun getAllCinema(): LiveData<List<Cinema>>

    @Delete
    suspend fun deleteCinema(cinema: Cinema)

}