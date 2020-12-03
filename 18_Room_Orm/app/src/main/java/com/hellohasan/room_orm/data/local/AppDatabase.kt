package com.hellohasan.room_orm.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.hellohasan.room_orm.data.repository.student.Student
import com.hellohasan.room_orm.data.repository.subject.Subject

@Database(entities = [Student::class, Subject::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun studentDao(): StudentDao
    abstract fun subjectDao(): SubjectDao

    companion object {
        fun getInstance(context: Context): AppDatabase {
            return Room.databaseBuilder(
                context,
                AppDatabase::class.java, "student-db"
            ).build()
        }
    }
}