package com.hellohasan.room_orm.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.hellohasan.room_orm.data.repository.student.Student
import com.hellohasan.room_orm.data.repository.subject.Subject

@Database(entities = [Student::class, Subject::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun studentDao(): StudentDao
    abstract fun subjectDao(): SubjectDao
}