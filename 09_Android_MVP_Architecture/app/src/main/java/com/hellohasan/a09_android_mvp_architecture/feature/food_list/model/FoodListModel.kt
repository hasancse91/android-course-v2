package com.hellohasan.a09_android_mvp_architecture.feature.food_list.model

import com.hellohasan.retrofitgetrequest.feature.food_list.model.FoodListCallback

interface FoodListModel {
    fun getFoodList(foodListCallback: FoodListCallback)
}