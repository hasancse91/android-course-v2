package com.hellohasan.a09_android_mvp_architecture.feature.food_list.model

import com.hellohasan.a09_android_mvp_architecture.feature.food_details.model.Food
import com.hellohasan.a09_android_mvp_architecture.network.FoodApiInterface
import com.hellohasan.a09_android_mvp_architecture.network.RetrofitClient
import com.hellohasan.retrofitgetrequest.feature.food_list.model.FoodListCallback
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
                    if (response.code() == 200)
                        foodListCallback.onSuccess(it)
                    else if (response.code() in 401..499)
                        foodListCallback.onError(Throwable("Unauthorized"))
                }
            }

            override fun onFailure(call: Call<MutableList<Food>>, t: Throwable) {
                foodListCallback.onError(t)
            }

        })
    }
}