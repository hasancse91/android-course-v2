package com.hellohasan.retrofitgetrequest.feature.food_list.model

import com.hellohasan.a09_android_mvp_architecture.feature.food_details.model.Food

interface FoodListCallback {
    fun onSuccess(foodList: MutableList<Food>)
    fun onError(throwable: Throwable)
}