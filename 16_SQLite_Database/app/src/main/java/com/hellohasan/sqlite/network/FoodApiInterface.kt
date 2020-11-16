package com.hellohasan.sqlite.network

import com.hellohasan.sqlite.feature.food_details.model.Food
import retrofit2.Call
import retrofit2.http.GET

interface FoodApiInterface {

    @GET("hasancse91/android-course-v2/master/15_Android_MVVM_Architecture/data/foodlist.json")
    fun getFoodList(): Call<MutableList<Food>>

    @GET("hasancse91/android-course-v2/master/15_Android_MVVM_Architecture/data/food.json")
    fun getFoodDetails(): Call<Food>
}