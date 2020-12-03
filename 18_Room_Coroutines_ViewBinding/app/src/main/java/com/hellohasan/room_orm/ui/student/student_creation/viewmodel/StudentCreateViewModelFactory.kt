package com.hellohasan.room_orm.ui.student.student_creation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.hellohasan.room_orm.data.repository.student.StudentRepository

class StudentCreateViewModelFactory(val repository: StudentRepository): ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(StudentCreateViewModel::class.java)) {
            return StudentCreateViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class name")
    }

}