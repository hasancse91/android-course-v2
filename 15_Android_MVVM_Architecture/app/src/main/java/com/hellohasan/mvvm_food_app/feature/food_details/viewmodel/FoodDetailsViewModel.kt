package com.hellohasan.mvvm_food_app.feature.food_details.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hellohasan.mvvm_food_app.core.DataFetchCallback
import com.hellohasan.mvvm_food_app.feature.food_details.model.Food
import com.hellohasan.mvvm_food_app.feature.food_details.model.FoodDetailsModel

class FoodDetailsViewModel (private val model: FoodDetailsModel): ViewModel() {

    val foodDetailsLiveData = MutableLiveData<Food>()
    val foodDetailsErrorLiveData = MutableLiveData<String>()
    val progressBarVisibility = MutableLiveData(false)

    fun getFoodDetails() {

        progressBarVisibility.postValue(true)

        model.getFoodDetails(object : DataFetchCallback<Food> {
            override fun onSuccess(data: Food) {
                progressBarVisibility.postValue(false)
                foodDetailsLiveData.postValue(data)
            }

            override fun onError(throwable: Throwable) {
                progressBarVisibility.postValue(false)
                foodDetailsErrorLiveData.postValue(throwable.localizedMessage)
            }
        })
    }
}