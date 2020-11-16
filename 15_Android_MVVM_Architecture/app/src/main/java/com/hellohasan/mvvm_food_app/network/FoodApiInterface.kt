package com.hellohasan.mvvm_food_app.network

import com.hellohasan.mvvm_food_app.feature.food_details.model.Food
import retrofit2.Call
import retrofit2.http.GET

interface FoodApiInterface {

    @GET("hasancse91/android-course-v2/master/09_Android_MVP_Architecture/data/foodlist.json")
    fun getFoodList(): Call<MutableList<Food>>

    @GET("hasancse91/android-course-v2/master/09_Android_MVP_Architecture/data/food.json")
    fun getFoodDetails(): Call<Food>
}