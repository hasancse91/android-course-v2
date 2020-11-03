package com.hellohasan.post_auth.feature.student_list.model

import com.hellohasan.post_auth.core.DataFetchCallback

interface StudentModel {
    fun getStudentList(callback: DataFetchCallback<StudentResponse>)
    fun getStudentById(id: Int, callback: DataFetchCallback<StudentResponse>)
}