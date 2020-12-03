package com.hellohasan.room_orm.ui.student_update.viewmodel

import androidx.lifecycle.ViewModel
import com.hellohasan.room_orm.data.repository.student.Student
import com.hellohasan.room_orm.data.repository.student.StudentRepository

class StudentUpdateViewModel(private val repository: StudentRepository): ViewModel() {

    fun updateStudentRecord(student: Student) {

    }
}