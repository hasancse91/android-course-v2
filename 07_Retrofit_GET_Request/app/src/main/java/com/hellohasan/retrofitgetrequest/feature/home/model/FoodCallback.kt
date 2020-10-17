package com.hellohasan.retrofitgetrequest.feature.home.model

interface FoodCallback {
    fun onSuccess(food: Food)
    fun onError(errorMessage: Throwable)
}