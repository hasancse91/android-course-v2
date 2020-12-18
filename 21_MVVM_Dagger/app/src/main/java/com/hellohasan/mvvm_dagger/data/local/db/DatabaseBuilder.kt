package com.hellohasan.mvvm_dagger.data.local.db

import android.content.Context
import androidx.room.Room
import com.hellohasan.mvvm_dagger.utils.DATABASE_NAME

object DatabaseBuilder {

    fun getInstance(context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            DATABASE_NAME
        ).build()
    }
}