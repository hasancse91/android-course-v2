package com.hellohasan.mvvm_dagger.data.local.db.student

import androidx.room.*
import com.hellohasan.mvvm_dagger.data.repository.student.Student

@Dao
interface StudentDao {
    
    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun insert(student: Student): Long

    @Query("SELECT * FROM student")
    suspend fun getAll(): MutableList<Student>

    @Query("SELECT * FROM student WHERE id = :id")
    suspend fun getById(id: Long): Student

    @Update
    suspend fun update(student: Student): Int

    @Delete
    suspend fun delete(student: Student): Int

    @Query("DELETE FROM student")
    suspend fun deleteAll(): Int
}