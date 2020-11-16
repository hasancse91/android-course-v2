package com.hellohasan.mvvm_food_app.feature.food_list.model

import com.hellohasan.mvvm_food_app.core.DataFetchCallback
import com.hellohasan.mvvm_food_app.feature.food_details.model.Food

interface FoodListModel {
    fun getFoodList(callback: DataFetchCallback<MutableList<Food>>)
}