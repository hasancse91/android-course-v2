package com.hellohasan.retrofitgetrequest.feature.food_list.model

import com.hellohasan.retrofitgetrequest.feature.food_details.model.Food
import com.hellohasan.retrofitgetrequest.network.FoodApiInterface
import com.hellohasan.retrofitgetrequest.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FoodListModelImpl: FoodListModel {

    private val apiInterface = RetrofitClient.getClient().create(FoodApiInterface::class.java)
    private val call = apiInterface.getFoodList()

    override fun getFoodList(foodListCallback: FoodListCallback) {

        call.enqueue(object : Callback<MutableList<Food>>{

            override fun onResponse(call: Call<MutableList<Food>>, response: Response<MutableList<Food>>) {
                response.body()?.let {
                    foodListCallback.onSuccess(it)
                }
            }

            override fun onFailure(call: Call<MutableList<Food>>, t: Throwable) {
                foodListCallback.onError(t)
            }

        })
    }
}