package com.example.kotlinmovie.di.main

import com.example.kotlinmovie.di.main.home.HomeModule
import com.example.kotlinmovie.di.main.home.HomeScope
import com.example.kotlinmovie.di.main.home.HomeViewModelModule
import com.example.kotlinmovie.di.main.profile.ProfileModule
import com.example.kotlinmovie.di.main.profile.ProfileScope
import com.example.kotlinmovie.di.main.profile.ProfileViewModelModule
import com.example.kotlinmovie.di.main.users.UsersModule
import com.example.kotlinmovie.di.main.users.UsersScope
import com.example.kotlinmovie.di.main.users.UsersViewModelModule
import com.example.kotlinmovie.ui.main.home.HomeFragment
import com.example.kotlinmovie.ui.main.profile.ProfileFragment
import com.example.kotlinmovie.ui.main.users.UserFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainFragmentBuildersModule {

    @HomeScope
    @ContributesAndroidInjector(
        modules = [HomeViewModelModule::class, HomeModule::class]
    )
    abstract fun contributeHomeFragment(): HomeFragment

    @UsersScope
    @ContributesAndroidInjector(
        modules = [UsersViewModelModule::class, UsersModule::class]
    )
    abstract fun contributeUsersFragment(): UserFragment

    @ProfileScope
    @ContributesAndroidInjector(
        modules = [ProfileViewModelModule::class, ProfileModule::class]
    )
    abstract fun contributeProfileFragment(): ProfileFragment
}