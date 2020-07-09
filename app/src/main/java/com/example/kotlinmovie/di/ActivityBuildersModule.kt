package com.example.kotlinmovie.di

import com.example.kotlinmovie.di.detail.DetailModule
import com.example.kotlinmovie.di.detail.DetailScope
import com.example.kotlinmovie.di.detail.DetailViewModelModule
import com.example.kotlinmovie.di.main.MainFragmentBuildersModule
import com.example.kotlinmovie.di.main.MainModule
import com.example.kotlinmovie.di.main.MainScope
import com.example.kotlinmovie.di.main.MainViewModelModule
import com.example.kotlinmovie.ui.detail.DetailActivity
import com.example.kotlinmovie.ui.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuildersModule {


    @MainScope
    @ContributesAndroidInjector(modules = [
        MainViewModelModule::class,
        MainModule::class,
        MainFragmentBuildersModule::class
    ])
    abstract fun contributeMainActivity(): MainActivity

    @DetailScope
    @ContributesAndroidInjector(modules = [
        DetailViewModelModule::class,
        DetailModule::class])
    abstract fun contributeDetailActivity(): DetailActivity
}
