package com.example.exampledagger.service

import com.example.exampledagger.data.User
import retrofit2.http.GET

interface ApiService {
@GET("users")
    suspend fun getUser():List<User>
}