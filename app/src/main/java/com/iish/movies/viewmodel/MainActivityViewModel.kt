package com.iish.movies.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.iish.movies.app.App
import com.iish.movies.di.RetrofitServiceInterface
import com.iish.movies.model.Cinema
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainActivityViewModel(application: Application) : AndroidViewModel(application) {

    @Inject
    lateinit var service: RetrofitServiceInterface
    private var allCinemaDataList: MutableLiveData<List<Cinema>> = MutableLiveData()
    val response: LiveData<List<Cinema>> get() = allCinemaDataList

    init {
        (application as App).getRetrofitComponent().inject(this)
        getCinemaFromApi()
    }

    fun getCinemaFromApi() = viewModelScope.launch {
        service.getData().let {
            if (it.isSuccessful) {
                allCinemaDataList.postValue(it.body())
            } else {
                Log.d(this@MainActivityViewModel.toString(), "MainActivityViewModel Error:${it.code()}")
            }
        }
    }

}