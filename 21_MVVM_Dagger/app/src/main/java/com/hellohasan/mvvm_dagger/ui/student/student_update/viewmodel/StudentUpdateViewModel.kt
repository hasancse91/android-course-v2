package com.hellohasan.mvvm_dagger.ui.student.student_update.viewmodel

import androidx.lifecycle.ViewModel
import com.hellohasan.mvvm_dagger.data.repository.student.Student
import com.hellohasan.mvvm_dagger.data.repository.student.StudentRepository
import javax.inject.Inject

class StudentUpdateViewModel @Inject constructor(private val repository: StudentRepository): ViewModel() {

    fun updateStudentRecord(student: Student) {

    }
}