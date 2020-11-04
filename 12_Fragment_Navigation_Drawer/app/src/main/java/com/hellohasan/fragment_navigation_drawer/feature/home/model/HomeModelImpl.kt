package com.hellohasan.fragment_navigation_drawer.feature.home.model

import com.hellohasan.fragment_navigation_drawer.core.DataFetchCallback
import com.hellohasan.fragment_navigation_drawer.network.ApiInterface
import com.hellohasan.fragment_navigation_drawer.network.RetrofitClient

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeModelImpl: HomeModel {

    override fun getCourseInformation(callback: DataFetchCallback<CourseInfoResponse>) {
        val retrofit = RetrofitClient.retrofit.create(ApiInterface::class.java)
        val call = retrofit.getCourseInformation()

        call.enqueue(object : Callback<CourseInfoResponse> {
            override fun onResponse(
                call: Call<CourseInfoResponse>,
                response: Response<CourseInfoResponse>
            ) {
                response.body()?.let {
                    callback.onSuccess(it)
                }
            }

            override fun onFailure(call: Call<CourseInfoResponse>, t: Throwable) {
                callback.onError(t)
            }

        })
    }
}