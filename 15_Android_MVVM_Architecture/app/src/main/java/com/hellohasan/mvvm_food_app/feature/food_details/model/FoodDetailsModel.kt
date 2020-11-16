package com.hellohasan.mvvm_food_app.feature.food_details.model

import com.hellohasan.mvvm_food_app.core.DataFetchCallback

interface FoodDetailsModel {
    fun getFoodDetails(callback: DataFetchCallback<Food>)
}