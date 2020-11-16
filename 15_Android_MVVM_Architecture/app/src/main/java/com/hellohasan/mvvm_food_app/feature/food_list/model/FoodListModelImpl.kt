package com.hellohasan.mvvm_food_app.feature.food_list.model

import com.hellohasan.mvvm_food_app.core.DataFetchCallback
import com.hellohasan.mvvm_food_app.feature.food_details.model.Food
import com.hellohasan.mvvm_food_app.network.FoodApiInterface
import com.hellohasan.mvvm_food_app.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FoodListModelImpl: FoodListModel {

    private val apiInterface = RetrofitClient.getClient().create(FoodApiInterface::class.java)
    private val call = apiInterface.getFoodList()

    override fun getFoodList(callback: DataFetchCallback<MutableList<Food>>) {

        call.enqueue(object : Callback<MutableList<Food>>{

            override fun onResponse(call: Call<MutableList<Food>>, response: Response<MutableList<Food>>) {
                response.body()?.let {
                    callback.onSuccess(it)
                }
            }

            override fun onFailure(call: Call<MutableList<Food>>, t: Throwable) {
                callback.onError(t)
            }

        })
    }
}