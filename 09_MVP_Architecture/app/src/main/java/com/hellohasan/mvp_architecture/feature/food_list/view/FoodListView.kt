package com.hellohasan.mvp_architecture.feature.food_list.view

import com.hellohasan.mvp_architecture.feature.food_details.model.Food

interface FoodListView {
    fun handleProgressBarVisibility(isVisible: Boolean)
    fun onFoodListFetchSuccess(foodList: MutableList<Food>)
    fun onFoodListFetchFailure(errorMessage: String)
}