package com.hellohasan.mvp_architecture.feature.food_details.model

interface FoodCallback {
    fun onSuccess(food: Food)
    fun onError(errorMessage: Throwable)
}