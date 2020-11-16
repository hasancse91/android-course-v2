package com.hellohasan.mvvm_food_app.feature.food_details.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.hellohasan.mvvm_food_app.feature.food_details.model.FoodDetailsModel

class FoodDetailsViewModelFactory(val model: FoodDetailsModel) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(FoodDetailsViewModel::class.java)) {
            return FoodDetailsViewModel(model) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class name")
    }
}