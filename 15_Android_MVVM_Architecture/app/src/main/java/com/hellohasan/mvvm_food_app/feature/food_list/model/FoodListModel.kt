package com.hellohasan.mvvm_food_app.feature.food_list.model

import com.hellohasan.retrofitgetrequest.feature.food_list.model.FoodListCallback

interface FoodListModel {
    fun getFoodList(foodListCallback: FoodListCallback)
}