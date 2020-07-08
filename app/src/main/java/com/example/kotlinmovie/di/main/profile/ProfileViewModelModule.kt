package com.example.kotlinmovie.di.main.profile

import androidx.lifecycle.ViewModel
import com.example.kotlinmovie.di.ViewModelKey
import com.example.kotlinmovie.ui.main.profile.ProfileViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ProfileViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(ProfileViewModel::class)
    abstract fun bindProfileViewModel(profileViewModel: ProfileViewModel) : ViewModel
}