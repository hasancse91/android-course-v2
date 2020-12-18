package com.hellohasan.mvvm_dagger.data.local.db.student

import com.hellohasan.mvvm_dagger.core.DataFetchCallback
import com.hellohasan.mvvm_dagger.data.local.db.AppDatabase
import com.hellohasan.mvvm_dagger.data.repository.student.Student
import com.orhanobut.logger.Logger
import javax.inject.Inject

class StudentLocalDataSourceImpl @Inject constructor(db: AppDatabase): StudentLocalDataSource {

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