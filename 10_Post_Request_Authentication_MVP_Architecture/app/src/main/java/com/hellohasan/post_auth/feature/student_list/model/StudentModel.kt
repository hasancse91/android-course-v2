package com.hellohasan.post_auth.feature.student_list.model

import com.hellohasan.post_auth.feature.login.model.ApiCallback

interface StudentModel {
    fun getStudentList(callback: ApiCallback<StudentResponse>)
    fun getStudentById(id: Int, callback: ApiCallback<StudentResponse>)
}