package com.example.kotlinmovie.di.main.users

import androidx.lifecycle.ViewModel
import com.example.kotlinmovie.di.ViewModelKey
import com.example.kotlinmovie.ui.main.users.UsersViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class UsersViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(UsersViewModel::class)
    abstract fun bindUsersViewModel(usersViewModel: UsersViewModel): ViewModel
}