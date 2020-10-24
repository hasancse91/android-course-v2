package com.hellohasan.a09_android_mvp_architecture.feature.food_details.model

import com.hellohasan.a09_android_mvp_architecture.network.FoodApiInterface
import com.hellohasan.a09_android_mvp_architecture.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FoodDetailsModelImpl: FoodDetailsModel {

    private val apiInterface = RetrofitClient.getClient().create(FoodApiInterface::class.java)
    private val call = apiInterface.getFoodDetails()

    override fun getFoodDetails(foodCallback: FoodCallback) {

        call.enqueue(object : Callback<Food> {

            override fun onResponse(call: Call<Food>, response: Response<Food>) {
                response.body()?.let {
                    foodCallback.onSuccess(it)
                }
            }

            override fun onFailure(call: Call<Food>, t: Throwable) {
                foodCallback.onError(t)
            }

        })
    }
}