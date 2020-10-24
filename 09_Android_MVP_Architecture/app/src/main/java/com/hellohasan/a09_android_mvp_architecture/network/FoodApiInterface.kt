package com.hellohasan.a09_android_mvp_architecture.network

import com.hellohasan.a09_android_mvp_architecture.feature.food_details.model.Food
import retrofit2.Call
import retrofit2.http.GET

interface FoodApiInterface {

    @GET("hasancse91/android-course-v2/master/08_Recap_RecyclerView_Retrofit/data/foodlist.json")
    fun getFoodList(): Call<MutableList<Food>>

    @GET("hasancse91/android-course-v2/master/07_Retrofit_GET_Request/data/food.json")
    fun getFoodDetails(): Call<Food>
}