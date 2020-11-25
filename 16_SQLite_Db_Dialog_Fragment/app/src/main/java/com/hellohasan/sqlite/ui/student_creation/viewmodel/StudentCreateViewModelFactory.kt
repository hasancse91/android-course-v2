package com.hellohasan.sqlite.ui.student_creation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.hellohasan.sqlite.data.model.student.StudentModel

class StudentCreateViewModelFactory(val model: StudentModel): ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(StudentCreateViewModel::class.java)) {
            return StudentCreateViewModel(model) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class name")
    }

}