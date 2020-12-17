package com.hellohasan.mvvm_dagger.ui.student.student_list.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.hellohasan.mvvm_dagger.data.repository.client_ip.IpInfoRepository
import com.hellohasan.mvvm_dagger.data.repository.student.StudentRepository

class StudentListViewModelFactory(
    private val studentRepository: StudentRepository,
    private val ipInfoRepository: IpInfoRepository
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(StudentListViewModel::class.java)) {
            return StudentListViewModel(studentRepository, ipInfoRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class name")
    }
}