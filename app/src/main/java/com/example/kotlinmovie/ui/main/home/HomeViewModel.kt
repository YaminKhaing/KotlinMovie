package com.example.kotlinmovie.ui.main.home

import android.util.Log
import androidx.lifecycle.LiveDataReactiveStreams
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import com.example.kotlinmovie.models.MovieListModel
import com.example.kotlinmovie.models.base.Resource
import com.example.kotlinmovie.repository.main.home.HomeRepository
import com.example.kotlinmovie.util.AppConstants
import com.example.kotlinmovie.util.AppConstants.Companion.DEVELOPER_KEY
import javax.inject.Inject

class HomeViewModel @Inject constructor(val homeRepository: HomeRepository) : ViewModel() {

    private val TAG = "HomeViewModel"

    private lateinit var mediatorLiveData: MediatorLiveData<Resource<MovieListModel>>
    private lateinit var movieList :MovieListModel // For pagination

    fun observeMovies(): MediatorLiveData<Resource<MovieListModel>>{

        mediatorLiveData=MediatorLiveData()
        mediatorLiveData.value = Resource.loading(MovieListModel())


        val source=LiveDataReactiveStreams.fromPublisher(
            this.homeRepository.getMovies(DEVELOPER_KEY, "en-US", 1)
        )

        mediatorLiveData.addSource(source) { resource ->

            movieList = resource.data
            mediatorLiveData.value = resource
            mediatorLiveData.removeSource(source)

            Log.e(TAG, "observePhotos: livedata " + mediatorLiveData.value!!.data  )
            Log.e(TAG, "observePhotos: list " + movieList )

        }

        return mediatorLiveData
    }

}