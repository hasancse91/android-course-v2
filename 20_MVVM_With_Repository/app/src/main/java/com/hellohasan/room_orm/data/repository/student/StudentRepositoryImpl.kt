package com.hellohasan.room_orm.data.repository.student

import android.content.Context
import com.hellohasan.room_orm.core.DataFetchCallback
import com.hellohasan.room_orm.data.local.db.student.StudentLocalDataSourceImpl

class StudentRepositoryImpl (context: Context): StudentRepository {

    private val studentLocalDataSource = StudentLocalDataSourceImpl(context)

    override suspend fun createStudent(student: Student, callback: DataFetchCallback<Long>) {

        studentLocalDataSource.createStudent(student, object : DataFetchCallback<Long> {
            override fun onSuccess(data: Long) {
                callback.onSuccess(data)
            }

            override fun onError(throwable: Throwable) {
                callback.onError(throwable)
            }
        })
    }

    override suspend fun getStudentList(callback: DataFetchCallback<MutableList<Student>>) {

        studentLocalDataSource.getStudentList(object : DataFetchCallback<MutableList<Student>> {
            override fun onSuccess(data: MutableList<Student>) {
                callback.onSuccess(data)
            }

            override fun onError(throwable: Throwable) {
                callback.onError(throwable)
            }
        })
    }

    override suspend fun updateStudent(student: Student, callback: DataFetchCallback<Int>) {

        studentLocalDataSource.updateStudent(student, object : DataFetchCallback<Int> {
            override fun onSuccess(data: Int) {
                callback.onSuccess(data)
            }

            override fun onError(throwable: Throwable) {
                callback.onError(throwable)
            }
        })
    }

    override suspend fun deleteStudent(student: Student, callback: DataFetchCallback<Int>) {

        studentLocalDataSource.deleteStudent(student, object : DataFetchCallback<Int> {
            override fun onSuccess(data: Int) {
                callback.onSuccess(data)
            }

            override fun onError(throwable: Throwable) {
                callback.onError(throwable)
            }
        })
    }
}