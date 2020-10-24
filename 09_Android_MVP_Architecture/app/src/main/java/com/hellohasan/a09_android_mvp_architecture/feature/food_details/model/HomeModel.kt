package com.hellohasan.a09_android_mvp_architecture.feature.food_details.model

import com.hellohasan.a09_android_mvp_architecture.feature.food_details.model.FoodCallback

interface HomeModel {
    fun getFoodDetails(foodCallback: FoodCallback)
}