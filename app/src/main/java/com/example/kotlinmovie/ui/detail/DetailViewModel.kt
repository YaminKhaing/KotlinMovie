package com.example.kotlinmovie.ui.detail

import android.util.Log
import androidx.lifecycle.LiveDataReactiveStreams
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import com.example.kotlinmovie.models.MovieInfoModel
import com.example.kotlinmovie.models.MovieListModel
import com.example.kotlinmovie.models.base.Resource
import com.example.kotlinmovie.repository.detail.DetailRepository
import javax.inject.Inject

class DetailViewModel @Inject constructor(val detailRepository: DetailRepository) : ViewModel() {

    private val TAG = "DetailViewModel"

    private lateinit var mediatorLiveData: MediatorLiveData<Resource<ArrayList<MovieInfoModel>>>
    private lateinit var movieList : ArrayList<MovieInfoModel> // For pagination

    fun observeMovieDetail(movieId: Int): MediatorLiveData<Resource<ArrayList<MovieInfoModel>>>{

//        movieList = ArrayList()
//        mediatorLiveData = MediatorLiveData()

        mediatorLiveData.value=Resource.loading(ArrayList())

        val source=LiveDataReactiveStreams.fromPublisher(
            this.detailRepository.getMovieDetail(movieId)
        )

        mediatorLiveData.addSource(source) { resource ->

            movieList = resource.data
            mediatorLiveData.value = resource
            mediatorLiveData.removeSource(source)

            Log.e(TAG, "observePhotos: livedata " + mediatorLiveData.value!!.data.size  )
            Log.e(TAG, "observePhotos: list " + movieList.size )

        }

        return mediatorLiveData
    }

}