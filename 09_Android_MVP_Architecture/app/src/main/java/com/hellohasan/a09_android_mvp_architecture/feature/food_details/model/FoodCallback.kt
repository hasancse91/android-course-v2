package com.hellohasan.a09_android_mvp_architecture.feature.food_details.model

import com.hellohasan.a09_android_mvp_architecture.feature.food_details.model.Food

interface FoodCallback {
    fun onSuccess(food: Food)
    fun onError(errorMessage: Throwable)
}