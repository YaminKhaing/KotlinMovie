package com.example.kotlinmovie.di.main.home

import com.example.kotlinmovie.network.HomeApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class HomeModule {

    @HomeScope
    @Provides
    fun provideHomeApi(retrofit: Retrofit) : HomeApi {
        return retrofit.create(HomeApi::class.java)
    }

}