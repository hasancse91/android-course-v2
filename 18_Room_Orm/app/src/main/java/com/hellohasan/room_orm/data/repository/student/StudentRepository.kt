package com.hellohasan.room_orm.data.repository.student

import com.hellohasan.room_orm.core.DataFetchCallback

interface StudentRepository {
    suspend fun insertStudent(student: Student, callback: DataFetchCallback<Long>)
    suspend fun getStudentList(callback: DataFetchCallback<MutableList<Student>>)
    suspend fun updateStudent(student: Student, callback: DataFetchCallback<Int>)
    suspend fun deleteStudent(student: Student, callback: DataFetchCallback<Int>)
}