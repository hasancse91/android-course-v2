package com.hellohasan.mvvm_dagger.data.repository.subject

import com.hellohasan.mvvm_dagger.core.DataFetchCallback

interface SubjectRepository {
    suspend fun createSubject(subject: Subject, callback: DataFetchCallback<Long>)
    suspend fun getSubjectList(callback: DataFetchCallback<MutableList<Subject>>)
    suspend fun updateSubject(subject: Subject, callback: DataFetchCallback<Int>)
    suspend fun deleteSubject(subject: Subject, callback: DataFetchCallback<Int>)
}