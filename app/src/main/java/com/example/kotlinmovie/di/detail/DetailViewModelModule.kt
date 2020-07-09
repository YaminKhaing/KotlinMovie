package com.example.kotlinmovie.di.detail

import androidx.lifecycle.ViewModel
import com.example.kotlinmovie.di.ViewModelKey
import com.example.kotlinmovie.ui.detail.DetailViewModel
import com.example.kotlinmovie.ui.main.home.HomeViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class DetailViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(DetailViewModel::class)
    abstract fun bindDetailViewModel(detailViewModel: DetailViewModel) : ViewModel
}