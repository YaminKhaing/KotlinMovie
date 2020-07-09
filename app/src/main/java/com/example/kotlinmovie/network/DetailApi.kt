package com.example.kotlinmovie.network

import com.example.kotlinmovie.models.MovieInfoModel
import com.example.kotlinmovie.models.MovieListModel
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface DetailApi {

    @GET("/movie/{movie_id}")
    fun getMovieDetail(@Path("movie_id") movieId: Int,
                       @Query("api_key") apiKey: String,
                       @Query("language") language: String): Flowable<ArrayList<MovieInfoModel>>?
}