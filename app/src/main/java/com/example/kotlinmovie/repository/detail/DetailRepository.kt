package com.example.kotlinmovie.repository.detail

import com.example.kotlinmovie.models.base.Resource
import com.example.kotlinmovie.models.MovieInfoModel
import com.example.kotlinmovie.network.DetailApi
import com.example.kotlinmovie.util.AppConstants
import com.example.kotlinmovie.util.AppConstants.Companion.CONNECTION_OR_SERVER_ERROR
import io.reactivex.Flowable
import io.reactivex.functions.Function
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class DetailRepository @Inject constructor(private val detailApi: DetailApi) {
    private val TAG = "DetailRepository"

    fun getMovieDetail(movieId:Int): Flowable<Resource<ArrayList<MovieInfoModel>>>{
        return detailApi.getMovieDetail(movieId, AppConstants.DEVELOPER_KEY, "en-US")!!
            .onErrorReturn(Function {
                val dummyList = ArrayList<MovieInfoModel>()
                val movieInfoModel = MovieInfoModel()
                movieInfoModel.id = -1
                return@Function dummyList
            })
            .map { movieInfoList: ArrayList<MovieInfoModel> ->
                if (movieInfoList != null){
                    if (movieInfoList.size > 0){
                        if (movieInfoList[0].id==-1){
                            return@map Resource.error(CONNECTION_OR_SERVER_ERROR, ArrayList<MovieInfoModel>())
                        }
                    }
                }
                return@map Resource.success(movieInfoList)
            }
            .subscribeOn(Schedulers.io())
    }

}