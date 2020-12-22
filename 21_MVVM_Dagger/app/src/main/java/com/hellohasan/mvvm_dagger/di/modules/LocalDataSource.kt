package com.hellohasan.mvvm_dagger.di.modules

import com.hellohasan.mvvm_dagger.data.local.db.student.StudentLocalDataSource
import com.hellohasan.mvvm_dagger.data.local.db.student.StudentLocalDataSourceImpl
import com.hellohasan.mvvm_dagger.data.local.db.subject.SubjectLocalDataSource
import com.hellohasan.mvvm_dagger.data.local.db.subject.SubjectLocalDataSourceImpl
import dagger.Binds
import dagger.Module

@Module
abstract class LocalDataSource {

    @Binds
    abstract fun bindStudentLocalDataSource(studentLocalDataSourceImpl: StudentLocalDataSourceImpl): StudentLocalDataSource

    @Binds
    abstract fun bindSubjectLocalDataSource(subjectLocalDataSourceImpl: SubjectLocalDataSourceImpl): SubjectLocalDataSource
}