package com.example.kotlinmovie.network

import com.example.kotlinmovie.models.MovieListModel
import io.reactivex.Flowable
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface HomeApi {

    @GET("movie/now_playing")
    fun getNowShowingMovies(
        @Query("api_key") apiKey: String,
        @Query("language") language: String,
        @Query("page") page: Int ): Flowable<MovieListModel>?

}