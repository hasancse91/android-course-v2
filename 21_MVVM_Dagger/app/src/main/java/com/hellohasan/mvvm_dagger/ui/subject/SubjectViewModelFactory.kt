package com.hellohasan.mvvm_dagger.ui.subject

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.hellohasan.mvvm_dagger.data.repository.subject.SubjectRepository

class SubjectViewModelFactory(private val repository: SubjectRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SubjectViewModel::class.java))
            return SubjectViewModel(repository) as T
        throw IllegalArgumentException("Unknown ViewModel class name")
    }
}