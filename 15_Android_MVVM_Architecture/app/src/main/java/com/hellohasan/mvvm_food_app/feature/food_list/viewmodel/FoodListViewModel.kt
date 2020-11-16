package com.hellohasan.mvvm_food_app.feature.food_list.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hellohasan.mvvm_food_app.feature.food_details.model.Food
import com.hellohasan.mvvm_food_app.feature.food_list.model.FoodListModel
import com.hellohasan.retrofitgetrequest.feature.food_list.model.FoodListCallback

class FoodListViewModel: ViewModel() {

    val foodListLiveData = MutableLiveData<MutableList<Food>>()
    val foodListErrorLiveData = MutableLiveData<String>()
    val progressBarVisibility = MutableLiveData(false)

    fun getFoodList(model: FoodListModel) {
        progressBarVisibility.postValue(true)

        model.getFoodList(object : FoodListCallback{

            override fun onSuccess(foodList: MutableList<Food>) {
                progressBarVisibility.postValue(false)
                foodListLiveData.postValue(foodList)
            }

            override fun onError(throwable: Throwable) {
                progressBarVisibility.postValue(false)
                foodListErrorLiveData.postValue(throwable.localizedMessage)
            }
        })
    }

}