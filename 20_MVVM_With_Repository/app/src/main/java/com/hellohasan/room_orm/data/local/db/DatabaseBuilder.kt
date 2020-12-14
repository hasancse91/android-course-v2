package com.hellohasan.room_orm.data.local.db

import android.content.Context
import androidx.room.Room
import com.hellohasan.room_orm.utils.DATABASE_NAME

object DatabaseBuilder {

    fun getInstance(context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            DATABASE_NAME
        ).build()
    }
}