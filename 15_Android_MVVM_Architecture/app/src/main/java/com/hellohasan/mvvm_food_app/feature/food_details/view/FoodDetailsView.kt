package com.hellohasan.mvvm_food_app.feature.food_details.view

import com.hellohasan.mvvm_food_app.feature.food_details.model.Food

interface FoodDetailsView {
    fun handleProgressBarVisibility(visibility: Int)
    fun onFoodDetailsFetchSuccess(food: Food)
    fun onFoodDetailsFetchFailure(errorMessage: String)
}