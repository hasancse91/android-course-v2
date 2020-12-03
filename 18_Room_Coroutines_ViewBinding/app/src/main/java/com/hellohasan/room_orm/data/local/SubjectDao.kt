package com.hellohasan.room_orm.data.local

import androidx.room.*
import com.hellohasan.room_orm.data.repository.subject.Subject

@Dao
interface SubjectDao {

    @Insert
    suspend fun insert(subject: Subject): Long

    @Query("SELECT * FROM subject")
    suspend fun getAll(): MutableList<Subject>

    @Query("SELECT * FROM subject WHERE id = :id")
    suspend fun getById(id: Long): Subject

    @Update
    suspend fun update(subject: Subject): Int

    @Delete
    suspend fun delete(subject: Subject): Int

    @Query("DELETE FROM subject")
    suspend fun deleteAll(): Int
}