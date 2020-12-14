package com.hellohasan.room_orm.data.repository.subject

import android.content.Context
import com.hellohasan.room_orm.core.DataFetchCallback
import com.hellohasan.room_orm.data.local.db.subject.SubjectLocalDataSourceImpl

class SubjectRepositoryImpl(context: Context): SubjectRepository {

    private val subjectLocalDataSource = SubjectLocalDataSourceImpl(context)

    override suspend fun createSubject(subject: Subject, callback: DataFetchCallback<Long>) {

        subjectLocalDataSource.createSubject(subject, object : DataFetchCallback<Long> {
            override fun onSuccess(data: Long) {
                callback.onSuccess(data)
            }

            override fun onError(throwable: Throwable) {
                callback.onError(throwable)
            }
        })
    }

    override suspend fun getSubjectList(callback: DataFetchCallback<MutableList<Subject>>) {

        subjectLocalDataSource.getSubjectList(object : DataFetchCallback<MutableList<Subject>> {
            override fun onSuccess(data: MutableList<Subject>) {
                callback.onSuccess(data)
            }

            override fun onError(throwable: Throwable) {
                callback.onError(throwable)
            }
        })
    }

    override suspend fun updateSubject(subject: Subject, callback: DataFetchCallback<Int>) {

        subjectLocalDataSource.updateSubject(subject, object : DataFetchCallback<Int> {
            override fun onSuccess(data: Int) {
                callback.onSuccess(data)
            }

            override fun onError(throwable: Throwable) {
                callback.onError(throwable)
            }
        })
    }

    override suspend fun deleteSubject(subject: Subject, callback: DataFetchCallback<Int>) {

        subjectLocalDataSource.deleteSubject(subject, object : DataFetchCallback<Int> {
            override fun onSuccess(data: Int) {
                callback.onSuccess(data)
            }

            override fun onError(throwable: Throwable) {
                callback.onError(throwable)
            }
        })
    }
}