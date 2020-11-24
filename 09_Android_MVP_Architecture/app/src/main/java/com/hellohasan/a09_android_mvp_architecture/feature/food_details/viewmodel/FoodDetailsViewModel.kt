package com.hellohasan.a09_android_mvp_architecture.feature.food_details.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hellohasan.a09_android_mvp_architecture.feature.food_details.model.Food
import com.hellohasan.a09_android_mvp_architecture.feature.food_details.model.FoodCallback
import com.hellohasan.a09_android_mvp_architecture.feature.food_details.model.FoodDetailsModel

class FoodDetailsViewModel(val model: FoodDetailsModel) : ViewModel() {

    val foodDetailsLiveData = MutableLiveData<Food>()
    val foodDetailsErrorLiveData = MutableLiveData<String>()
    val progressBarVisibility = MutableLiveData(false)

    fun getFoodDetails() {

        progressBarVisibility.postValue(true)

        model.getFoodDetails(object : FoodCallback {

            override fun onSuccess(food: Food) {
                progressBarVisibility.postValue(false)
                foodDetailsLiveData.postValue(food)
            }

            override fun onError(errorMessage: Throwable) {
                progressBarVisibility.postValue(false)
                foodDetailsErrorLiveData.postValue(errorMessage.localizedMessage)
            }
        })
    }
}