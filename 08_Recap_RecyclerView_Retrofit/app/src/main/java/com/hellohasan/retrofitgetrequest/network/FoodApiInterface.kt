package com.hellohasan.retrofitgetrequest.network

import com.hellohasan.retrofitgetrequest.feature.food_details.model.Food
import retrofit2.Call
import retrofit2.http.GET

interface FoodApiInterface {

    @GET("shakircam/CollegeList/master/app/src/main/java/com/example/collegelist/foodList")
    fun getFoodList(): Call<MutableList<Food>>

    @GET("hasancse91/android-course-v2/master/07_Retrofit_GET_Request/data/food.json")
    fun getFoodDetails(): Call<Food>
}