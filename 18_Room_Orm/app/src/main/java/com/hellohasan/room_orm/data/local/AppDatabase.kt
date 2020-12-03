package com.hellohasan.room_orm.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.hellohasan.room_orm.data.repository.student.Student
import com.hellohasan.room_orm.data.repository.subject.Subject
import com.hellohasan.room_orm.utils.DATABASE_VERSION

@Database(entities = [Student::class, Subject::class], version = DATABASE_VERSION)
abstract class AppDatabase : RoomDatabase() {

    abstract fun studentDao(): StudentDao
    abstract fun subjectDao(): SubjectDao
}