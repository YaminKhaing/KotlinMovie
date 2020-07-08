package com.example.kotlinmovie.di.main.home

import androidx.lifecycle.ViewModel
import com.example.kotlinmovie.di.ViewModelKey
import com.example.kotlinmovie.ui.main.home.HomeViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class HomeViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    abstract fun bindHomeViewModel(homeViewModel: HomeViewModel) : ViewModel
}