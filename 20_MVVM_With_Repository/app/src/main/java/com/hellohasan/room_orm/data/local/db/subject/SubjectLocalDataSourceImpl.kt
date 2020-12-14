package com.hellohasan.room_orm.data.local.db.subject

import android.content.Context
import com.hellohasan.room_orm.core.DataFetchCallback
import com.hellohasan.room_orm.data.local.db.DatabaseBuilder
import com.hellohasan.room_orm.data.repository.subject.Subject

class SubjectLocalDataSourceImpl(context: Context) : SubjectLocalDataSource {

    private val db = DatabaseBuilder.getInstance(context)
    private val subjectDao = db.subjectDao()

    override suspend fun createSubject(subject: Subject, callback: DataFetchCallback<Long>) {
        try {
            callback.onSuccess(subjectDao.insert(subject))
        } catch (e: Exception) {
            callback.onError(e)
        }
    }

    override suspend fun getSubjectList(callback: DataFetchCallback<MutableList<Subject>>) {
        try {
            callback.onSuccess(subjectDao.getAll())
        } catch (e: Exception) {
            callback.onError(e)
        }
    }

    override suspend fun updateSubject(subject: Subject, callback: DataFetchCallback<Int>) {
        try {
            callback.onSuccess(subjectDao.update(subject))
        } catch (e: Exception) {
            callback.onError(e)
        }
    }

    override suspend fun deleteSubject(subject: Subject, callback: DataFetchCallback<Int>) {
        try {
            callback.onSuccess(subjectDao.delete(subject))
        } catch (e: Exception) {
            callback.onError(e)
        }
    }
}