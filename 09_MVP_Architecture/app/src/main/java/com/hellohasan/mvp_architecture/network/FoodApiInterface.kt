package com.hellohasan.mvp_architecture.network

import com.hellohasan.mvp_architecture.feature.food_details.model.Food
import retrofit2.Call
import retrofit2.http.GET

interface FoodApiInterface {

    @GET("hasancse91/android-course-v2/master/09_MVP_Architecture/data/foodlist.json")
    fun getFoodList(): Call<MutableList<Food>>

    @GET("hasancse91/android-course-v2/master/09_MVP_Architecture/data/food.json")
    fun getFoodDetails(): Call<Food>
}