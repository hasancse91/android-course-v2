package com.hellohasan.sqlite.ui.student_update.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.hellohasan.sqlite.data.model.student.StudentModel

class StudentUpdateViewModelFactory(private val model: StudentModel): ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(StudentUpdateViewModel::class.java)) {
            return StudentUpdateViewModel(model) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class name")
    }
}