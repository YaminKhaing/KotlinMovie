package com.example.kotlinmovie

import com.example.kotlinmovie.custom_control.AndroidCommonSetup
import com.example.kotlinmovie.di.DaggerAppComponent
import dagger.android.support.DaggerApplication

class BaseApplication : DaggerApplication() {

    override fun onCreate() {
        super.onCreate()

        AndroidCommonSetup.getInstance().init(applicationContext)
    }

    private val applicationInjector = DaggerAppComponent.builder()
        .application(this).build()

    override fun applicationInjector() = applicationInjector
}