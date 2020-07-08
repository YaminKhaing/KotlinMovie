package com.example.kotlinmovie.repository.main.home

import android.util.Log
import com.example.kotlinmovie.models.MovieListModel
import com.example.kotlinmovie.models.base.Resource
import com.example.kotlinmovie.network.HomeApi
import com.example.kotlinmovie.util.AppConstants
import com.example.kotlinmovie.util.AppConstants.Companion.CONNECTION_OR_SERVER_ERROR
import io.reactivex.Flowable
import io.reactivex.functions.Function
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class HomeRepository @Inject constructor(private val homeApi: HomeApi){

    private val TAG = "HomeRepository"

    fun getMovies(apiKey : String, lang: String, page: Int): Flowable<Resource<MovieListModel>>{
        return homeApi.getNowShowingMovies(AppConstants.DEVELOPER_KEY, "en-US", 1)!!
            .onErrorReturn(Function {
                val movieListModel=MovieListModel()
                movieListModel.results= emptyList()
                return@Function movieListModel
            })
            .map { movieListModel: MovieListModel ->
                if(movieListModel != null){
                    if(movieListModel.results.isEmpty()){
                        Log.d(TAG, "getMovies: "+ movieListModel.results)
                        Log.e(TAG, "getMovies: " + movieListModel.total_pages )
                        return@map Resource.error(CONNECTION_OR_SERVER_ERROR, MovieListModel())
                    }
                }
                return@map Resource.success(movieListModel)
            }
            .subscribeOn(Schedulers.io())

    }

}