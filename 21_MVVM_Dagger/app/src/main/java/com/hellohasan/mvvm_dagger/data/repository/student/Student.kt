package com.hellohasan.mvvm_dagger.data.repository.student

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import com.hellohasan.mvvm_dagger.utils.*

@Entity(indices = [Index(value = [COLUMN_STUDENT_REGISTRATION], unique = true)])
data class Student(
    @PrimaryKey(autoGenerate = true) var id: Long = 0, // have to set 0 for auto generate ID
    @ColumnInfo(name = COLUMN_STUDENT_NAME) var name: String,
    @ColumnInfo(name = COLUMN_STUDENT_REGISTRATION) var registrationNumber: Long,
    @ColumnInfo(name = COLUMN_STUDENT_PHONE) var phoneNumber: String,
    @ColumnInfo(name = COLUMN_STUDENT_EMAIL) var email: String
)