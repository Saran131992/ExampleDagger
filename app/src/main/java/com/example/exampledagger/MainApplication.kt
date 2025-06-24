package com.example.exampledagger

import android.app.Application
import com.example.exampledagger.di.AppComponent
import com.example.exampledagger.di.DaggerAppComponent

class MainApplication : Application() {

    lateinit var appComponent: AppComponent
    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.create()
    }
}