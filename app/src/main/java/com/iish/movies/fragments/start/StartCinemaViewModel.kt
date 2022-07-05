package com.iish.movies.fragments.start

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.iish.movies.app.App
import com.iish.movies.data.repository.CinemaRepository
import com.iish.movies.model.Cinema
import kotlinx.coroutines.launch
import javax.inject.Inject

class StartCinemaViewModel(application: Application): AndroidViewModel(application) {
    @Inject
    lateinit var cinemaRepository: CinemaRepository
    val response: LiveData<List<Cinema>> get() = cinemaRepository.allCinema
    var foundedCinema: LiveData<List<Cinema>>? = null
    private val _loadContent = MutableLiveData(false)
    var loadContent:LiveData<Boolean> = _loadContent

    init {
        (application as App).getRetrofitComponent().inject(this)
        getCinemaFromDB()
    }

    private fun getCinemaFromDB() = viewModelScope.launch {
        cinemaRepository.loadData()
    }

    fun findCinemaByName(name:String){
        cinemaRepository.findCinema(name)
        foundedCinema = cinemaRepository.findedCinema
    }

    fun contentHasLoaded(){
        _loadContent.value.let {
            _loadContent.value = !it!!
        }
    }
}