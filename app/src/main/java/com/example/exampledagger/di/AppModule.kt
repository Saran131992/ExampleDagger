package com.example.exampledagger.di

import com.example.exampledagger.UserRepository
import com.example.exampledagger.service.ApiService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
class AppModule {
    @Provides
    fun provideUserRepository(): UserRepository {
        return UserRepository()

    }
    @Provides
  fun provideRetrofit():Retrofit{
      return Retrofit.Builder()
          .baseUrl("https://jsonplaceholder.typicode.com/")
          .addConverterFactory(GsonConverterFactory.create())
          .build()
  }
    @Provides
    fun provideApiService(retrofit: Retrofit):ApiService{

        return retrofit.create(ApiService::class.java)

    }

}