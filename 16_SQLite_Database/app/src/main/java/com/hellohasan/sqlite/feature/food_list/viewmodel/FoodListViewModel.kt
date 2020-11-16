package com.hellohasan.sqlite.feature.food_list.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hellohasan.sqlite.core.DataFetchCallback
import com.hellohasan.sqlite.feature.food_details.model.Food
import com.hellohasan.sqlite.feature.food_list.model.FoodListModel

class FoodListViewModel: ViewModel() {

    val foodListLiveData = MutableLiveData<MutableList<Food>>()
    val foodListErrorLiveData = MutableLiveData<String>()
    val progressBarVisibility = MutableLiveData(false)

    fun getFoodList(model: FoodListModel) {
        progressBarVisibility.postValue(true)

        model.getFoodList(object : DataFetchCallback<MutableList<Food>>{

            override fun onSuccess(data: MutableList<Food>) {
                progressBarVisibility.postValue(false)
                foodListLiveData.postValue(data)
            }

            override fun onError(throwable: Throwable) {
                progressBarVisibility.postValue(false)
                foodListErrorLiveData.postValue(throwable.localizedMessage)
            }
        })
    }

}