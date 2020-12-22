package com.hellohasan.mvp_architecture.feature.food_details.view

import com.hellohasan.mvp_architecture.feature.food_details.model.Food

interface FoodDetailsView {
    fun handleProgressBarVisibility(visibility: Int)
    fun onFoodDetailsFetchSuccess(food: Food)
    fun onFoodDetailsFetchFailure(errorMessage: String)
}