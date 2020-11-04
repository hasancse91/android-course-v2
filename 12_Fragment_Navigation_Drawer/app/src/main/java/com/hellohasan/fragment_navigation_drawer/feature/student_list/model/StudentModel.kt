package com.hellohasan.fragment_navigation_drawer.feature.student_list.model

import com.hellohasan.fragment_navigation_drawer.core.DataFetchCallback
import com.hellohasan.post_auth.feature.student_list.model.StudentResponse

interface StudentModel {
    fun getStudentList(callback: DataFetchCallback<StudentResponse>)
    fun getStudentById(id: Int, callback: DataFetchCallback<StudentResponse>)
}