package com.example.kotlinmovie.di

import androidx.lifecycle.ViewModelProvider
import com.example.kotlinmovie.viewmodels.ViewModelProviderFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelFactoryModule {
    @Binds
    abstract fun bindViewModelFactory(viewModelFactory: ViewModelProviderFactory?): ViewModelProvider.Factory?
}