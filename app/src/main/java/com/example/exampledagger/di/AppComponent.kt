package com.example.exampledagger.di

import com.example.exampledagger.MainActivity
import dagger.Component

@Component(modules = [AppModule::class])
interface AppComponent {
    fun inject (mainActivity: MainActivity)
}