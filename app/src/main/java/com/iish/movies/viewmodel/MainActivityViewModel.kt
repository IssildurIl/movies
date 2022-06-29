package com.iish.movies.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.iish.movies.app.App
import com.iish.movies.data.repository.CinemaRepository
import com.iish.movies.model.Cinema
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainActivityViewModel(application: Application) : AndroidViewModel(application) {

    @Inject
    lateinit var cinemaRepository: CinemaRepository
    val response: LiveData<List<Cinema>> get() = cinemaRepository.allCinema

    init {
        (application as App).getRetrofitComponent().inject(this)
        getCinemaFromDB()
    }

    private fun getCinemaFromDB() = viewModelScope.launch {
        cinemaRepository.loadData()
    }
}
