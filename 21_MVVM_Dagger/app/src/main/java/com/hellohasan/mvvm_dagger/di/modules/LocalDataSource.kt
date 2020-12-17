package com.hellohasan.mvvm_dagger.di.modules

import android.content.Context
import com.hellohasan.mvvm_dagger.data.local.db.AppDatabase
import com.hellohasan.mvvm_dagger.data.local.db.DatabaseBuilder
import com.hellohasan.mvvm_dagger.data.local.db.student.StudentLocalDataSource
import com.hellohasan.mvvm_dagger.data.local.db.student.StudentLocalDataSourceImpl
import com.hellohasan.mvvm_dagger.data.local.db.subject.SubjectLocalDataSource
import com.hellohasan.mvvm_dagger.data.local.db.subject.SubjectLocalDataSourceImpl
import com.hellohasan.mvvm_dagger.di.annotation.ApplicationContext
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
    fun provideSubjectLocalDataSource(@ApplicationContext context: Context) : SubjectLocalDataSource {
        return SubjectLocalDataSourceImpl(context)
    }
}