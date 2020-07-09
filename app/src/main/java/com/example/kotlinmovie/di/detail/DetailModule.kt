package com.example.kotlinmovie.di.detail

import com.example.kotlinmovie.di.main.home.HomeScope
import com.example.kotlinmovie.network.DetailApi
import com.example.kotlinmovie.network.HomeApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class DetailModule {

    @DetailScope
    @Provides
    fun provideDetailApi(retrofit: Retrofit) : DetailApi {
        return retrofit.create(DetailApi::class.java)
    }


}