package com.hellohasan.post_auth.network

import com.hellohasan.post_auth.feature.food_details.model.Food
import com.hellohasan.post_auth.feature.login.model.LoginResponse
import com.hellohasan.post_auth.feature.student_list.model.StudentResponse
import com.hellohasan.post_auth.feature.login.model.UserCredential
import retrofit2.Call
import retrofit2.http.*

interface ApiInterface {

    @POST("/login.php")
    fun login(@Body userCredential: UserCredential, @Header("api_key") apiKey: String) : Call<LoginResponse>

    @GET("/student.php")
    fun getStudentList(@Header("api_key") apiKey: String, @Header("token") token: String) : Call<StudentResponse>

    @GET("/student.php")
    fun getStudent(@Header("api_key") apiKey: String, @Header("token") token: String, @Query("id") id: Int) : Call<StudentResponse>
}