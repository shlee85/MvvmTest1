package com.example.mvvmtest1

import retrofit2.Call
import retrofit2.http.GET

interface RandomNumberApi {
    @GET("api/v1.0/random?min=1&max=100&count=1")
    fun getRandomNumber(): Call<List<Int>>
}
