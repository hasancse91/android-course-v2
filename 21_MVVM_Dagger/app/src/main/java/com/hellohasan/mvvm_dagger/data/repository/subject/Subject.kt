package com.hellohasan.mvvm_dagger.data.repository.subject

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.hellohasan.mvvm_dagger.data.repository.student.Student
import com.hellohasan.mvvm_dagger.utils.*

@Entity(
    foreignKeys = [ForeignKey(
        entity = Student::class,
        parentColumns = arrayOf(COLUMN_STUDENT_REGISTRATION),
        childColumns = arrayOf(COLUMN_REGISTRATION_NUMBER_FK),
        onDelete = ForeignKey.CASCADE
    )]
)
data class Subject(
    @PrimaryKey(autoGenerate = true) var id: Long = 0, // have to set 0 for auto generate ID
    @ColumnInfo(name = COLUMN_REGISTRATION_NUMBER_FK, index = true) val registrationNumber: Long,
    @ColumnInfo(name = COLUMN_SUBJECT_NAME) val name: String,
    @ColumnInfo(name = COLUMN_SUBJECT_CODE) val code: Int,
    @ColumnInfo(name = COLUMN_SUBJECT_CREDIT) val credit: Float
)