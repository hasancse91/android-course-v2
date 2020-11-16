package com.hellohasan.mvvm_food_app.feature.food_list.view

import com.hellohasan.mvvm_food_app.feature.food_details.model.Food

interface FoodListView {
    fun handleProgressBarVisibility(isVisible: Boolean)
    fun onFoodListFetchSuccess(foodList: MutableList<Food>)
    fun onFoodListFetchFailure(errorMessage: String)
}