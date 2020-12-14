package com.hellohasan.room_orm.ui.subject

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.hellohasan.room_orm.data.repository.subject.SubjectRepository

class SubjectViewModelFactory(private val repository: SubjectRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SubjectViewModel::class.java))
            return SubjectViewModel(repository) as T
        throw IllegalArgumentException("Unknown ViewModel class name")
    }
}