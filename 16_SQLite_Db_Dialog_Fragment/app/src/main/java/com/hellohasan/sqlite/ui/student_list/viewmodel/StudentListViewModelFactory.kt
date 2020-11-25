package com.hellohasan.sqlite.ui.student_list.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.hellohasan.sqlite.data.model.student.StudentModel

class StudentListViewModelFactory(private val model: StudentModel): ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(StudentListViewModel::class.java)) {
            return StudentListViewModel(model) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class name")
    }
}