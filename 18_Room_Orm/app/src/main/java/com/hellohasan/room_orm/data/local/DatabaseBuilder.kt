package com.hellohasan.room_orm.data.local

import android.content.Context
import androidx.room.Room

object DatabaseBuilder {

    fun getInstance(context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java, "student-db"
        ).build()
    }
}