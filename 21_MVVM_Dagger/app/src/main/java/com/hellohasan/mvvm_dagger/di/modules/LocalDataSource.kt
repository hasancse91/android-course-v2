package com.hellohasan.mvvm_dagger.di.modules

import com.hellohasan.mvvm_dagger.data.local.db.AppDatabase
import com.hellohasan.mvvm_dagger.data.local.db.student.StudentLocalDataSource
import com.hellohasan.mvvm_dagger.data.local.db.student.StudentLocalDataSourceImpl
import com.hellohasan.mvvm_dagger.data.local.db.subject.SubjectLocalDataSource
import com.hellohasan.mvvm_dagger.data.local.db.subject.SubjectLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object LocalDataSource {

    @Provides
    @Singleton
    fun provideStudentLocalDataSource(appDatabase: AppDatabase) : StudentLocalDataSource {
        return StudentLocalDataSourceImpl(appDatabase)
    }

    @Provides
    @Singleton
    fun provideSubjectLocalDataSource(appDatabase: AppDatabase) : SubjectLocalDataSource {
        return SubjectLocalDataSourceImpl(appDatabase)
    }
}