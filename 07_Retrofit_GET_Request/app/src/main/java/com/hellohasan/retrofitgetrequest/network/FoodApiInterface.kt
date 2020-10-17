package com.hellohasan.retrofitgetrequest.network

import com.hellohasan.retrofitgetrequest.feature.home.model.Food
import retrofit2.Call
import retrofit2.http.GET

interface FoodApiInterface {

    @GET("food.json")
    fun getFoodDetails(): Call<Food>
}