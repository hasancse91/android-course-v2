package com.hellohasan.mvvm_dagger.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.hellohasan.mvvm_dagger.data.local.db.student.StudentDao
import com.hellohasan.mvvm_dagger.data.local.db.subject.SubjectDao
import com.hellohasan.mvvm_dagger.data.repository.student.Student
import com.hellohasan.mvvm_dagger.data.repository.subject.Subject
import com.hellohasan.mvvm_dagger.utils.DATABASE_VERSION

@Database(entities = [Student::class, Subject::class], version = DATABASE_VERSION)
abstract class AppDatabase : RoomDatabase() {

    abstract fun studentDao(): StudentDao
    abstract fun subjectDao(): SubjectDao
}