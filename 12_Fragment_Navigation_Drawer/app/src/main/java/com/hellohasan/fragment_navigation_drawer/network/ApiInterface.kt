package com.hellohasan.fragment_navigation_drawer.network

import com.hellohasan.fragment_navigation_drawer.feature.home.model.CourseInfoResponse
import com.hellohasan.fragment_navigation_drawer.feature.login.model.LoginResponse
import com.hellohasan.post_auth.feature.student_list.model.StudentResponse
import com.hellohasan.fragment_navigation_drawer.feature.login.model.UserCredential
import retrofit2.Call
import retrofit2.http.*

interface ApiInterface {

    @GET("course_info.php")
    fun getCourseInformation() : Call<CourseInfoResponse>

    @POST("/login.php")
    fun login(@Body userCredential: UserCredential, @Header("api_key") apiKey: String) : Call<LoginResponse>

    @GET("/student.php")
    fun getStudentList(@Header("api_key") apiKey: String, @Header("token") token: String) : Call<StudentResponse>

    @GET("/student.php")
    fun getStudent(@Header("api_key") apiKey: String, @Header("token") token: String, @Query("id") id: Int) : Call<StudentResponse>
}