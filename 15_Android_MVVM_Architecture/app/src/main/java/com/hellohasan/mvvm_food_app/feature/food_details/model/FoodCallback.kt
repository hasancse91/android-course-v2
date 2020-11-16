package com.hellohasan.mvvm_food_app.feature.food_details.model

interface FoodCallback {
    fun onSuccess(food: Food)
    fun onError(errorMessage: Throwable)
}