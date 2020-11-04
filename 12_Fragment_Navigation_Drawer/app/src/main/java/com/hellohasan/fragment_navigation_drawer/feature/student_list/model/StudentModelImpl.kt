package com.hellohasan.post_auth.feature.student_list.model

import android.content.Context
import com.hellohasan.fragment_navigation_drawer.R
import com.hellohasan.fragment_navigation_drawer.core.DataFetchCallback
import com.hellohasan.fragment_navigation_drawer.feature.student_list.model.StudentModel
import com.hellohasan.fragment_navigation_drawer.network.ApiInterface
import com.hellohasan.fragment_navigation_drawer.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class StudentModelImpl (private val context: Context): StudentModel {

    private val apiInterface = RetrofitClient.getClient().create(ApiInterface::class.java)

    override fun getStudentList(callback: DataFetchCallback<StudentResponse>) {

        // token should be fetched from sharedPreference
        val call = apiInterface.getStudentList(context.getString(R.string.api_key), "token")

        call.enqueue(object : Callback<StudentResponse> {
            override fun onResponse(
                    call: Call<StudentResponse>,
                    response: Response<StudentResponse>
            ) {

                response.body()?.let { callback.onSuccess(it) }

            }

            override fun onFailure(call: Call<StudentResponse>, t: Throwable) {
                callback.onError(t)
            }

        })
    }

    override fun getStudentById(id: Int, callback: DataFetchCallback<StudentResponse>) {

        // apiKey can be fetched from string resource. token should be fetched from sharedPreference
        val call = apiInterface.getStudent("apiKey", "token", id)

        call.enqueue(object: Callback<StudentResponse> {
            override fun onResponse(
                    call: Call<StudentResponse>,
                    response: Response<StudentResponse>
            ) {
                response.body()?.let { callback.onSuccess(it) }
            }

            override fun onFailure(call: Call<StudentResponse>, t: Throwable) {
                callback.onError(t)
            }

        })
    }
}