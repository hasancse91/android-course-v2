package com.hellohasan.room_orm.ui.student.student_list.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.hellohasan.room_orm.data.repository.student.StudentRepository

class StudentListViewModelFactory(private val repository: StudentRepository): ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(StudentListViewModel::class.java)) {
            return StudentListViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class name")
    }
}