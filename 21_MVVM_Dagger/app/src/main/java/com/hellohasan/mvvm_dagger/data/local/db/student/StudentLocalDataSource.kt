package com.hellohasan.mvvm_dagger.data.local.db.student

import com.hellohasan.mvvm_dagger.core.DataFetchCallback
import com.hellohasan.mvvm_dagger.data.repository.student.Student

interface StudentLocalDataSource {
    suspend fun createStudent(student: Student, callback: DataFetchCallback<Long>)
    suspend fun getStudentList(callback: DataFetchCallback<MutableList<Student>>)
    suspend fun updateStudent(student: Student, callback: DataFetchCallback<Int>)
    suspend fun deleteStudent(student: Student, callback: DataFetchCallback<Int>)
}