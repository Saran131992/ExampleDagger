package com.example.exampledagger

import javax.inject.Inject

class UserRepository @Inject constructor() {

    fun getUser(): String = "saro"


}