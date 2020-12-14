package com.hellohasan.room_orm.data.local.db.student

import android.content.Context
import com.hellohasan.room_orm.core.DataFetchCallback
import com.hellohasan.room_orm.data.local.db.DatabaseBuilder
import com.hellohasan.room_orm.data.repository.student.Student
import com.orhanobut.logger.Logger

class StudentLocalDataSourceImpl(context: Context): StudentLocalDataSource {

    private val db = DatabaseBuilder.getInstance(context)
    private val studentDao = db.studentDao()

    override suspend fun createStudent(student: Student, callback: DataFetchCallback<Long>) {
        try {
            callback.onSuccess(studentDao.insert(student))
        } catch (e: Exception) {
            callback.onError(e)
            Logger.e(e.localizedMessage)
        }
    }

    override suspend fun getStudentList(callback: DataFetchCallback<MutableList<Student>>) {
        try {
            callback.onSuccess(studentDao.getAll())
        } catch (e: Exception) {
            callback.onError(e)
            Logger.e(e.localizedMessage)
        }
    }

    override suspend fun updateStudent(student: Student, callback: DataFetchCallback<Int>) {
        try {
            callback.onSuccess(studentDao.update(student))
        } catch (e: Exception) {
            callback.onError(e)
            Logger.e(e.localizedMessage)
        }
    }

    override suspend fun deleteStudent(student: Student, callback: DataFetchCallback<Int>) {
        try {
            callback.onSuccess(studentDao.delete(student))
        } catch (e: Exception) {
            callback.onError(e)
            Logger.e(e.localizedMessage)
        }
    }
}