package com.hellohasan.sqlite.data.model.student

import com.hellohasan.sqlite.core.DataFetchCallback

interface StudentModel {
    fun insertStudent(student: Student, callback: DataFetchCallback<Student>)
    fun getStudentList(callback: DataFetchCallback<MutableList<Student>>)
    fun updateStudent(student: Student, callback: DataFetchCallback<Int>)
    fun deleteStudent(id: Long, callback: DataFetchCallback<Int>)
}