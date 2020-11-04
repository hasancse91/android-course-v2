package com.hellohasan.fragment_navigation_drawer.network

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    private const val BASE_URL = "https://test.hellohasan.com/android-course-api/"

    private val gson = GsonBuilder().setLenient().create()

    val retrofit : Retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

    fun getClient(): Retrofit {
        return retrofit
    }
}