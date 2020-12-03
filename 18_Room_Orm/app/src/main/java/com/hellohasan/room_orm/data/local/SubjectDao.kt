package com.hellohasan.room_orm.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.hellohasan.room_orm.data.repository.subject.Subject

@Dao
interface SubjectDao {

    @Insert
    suspend fun insert(subject: Subject): Long

    @Query("SELECT * FROM subject")
    suspend fun getAll(): List<Subject>

    @Query("SELECT * FROM subject WHERE id = :id")
    suspend fun getById(id: Long): Subject

    @Delete
    suspend fun delete(subject: Subject): Int

    @Query("DELETE FROM subject")
    suspend fun deleteAll(): Int
}