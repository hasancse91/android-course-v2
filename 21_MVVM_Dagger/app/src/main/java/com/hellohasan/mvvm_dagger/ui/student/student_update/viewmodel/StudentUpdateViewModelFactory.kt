package com.hellohasan.mvvm_dagger.ui.student.student_update.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.hellohasan.mvvm_dagger.data.repository.student.StudentRepository

class StudentUpdateViewModelFactory(private val repository: StudentRepository): ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(StudentUpdateViewModel::class.java)) {
            return StudentUpdateViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class name")
    }
}