package com.hellohasan.mvvm_dagger.ui.student.student_creation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hellohasan.mvvm_dagger.core.DataFetchCallback
import com.hellohasan.mvvm_dagger.data.repository.student.Student
import com.hellohasan.mvvm_dagger.data.repository.student.StudentRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

class StudentCreateViewModel @Inject constructor(private val repository: StudentRepository): ViewModel() {

    val studentCreationSuccessLiveData = MutableLiveData<Unit>()
    val studentCreationFailedLiveData = MutableLiveData<String>()

    fun createStudent(student: Student) {

        viewModelScope.launch {
            repository.createStudent(student, object : DataFetchCallback<Long> {
                override fun onSuccess(data: Long) {
                    studentCreationSuccessLiveData.postValue(Unit)
                }

                override fun onError(throwable: Throwable) {
                    studentCreationFailedLiveData.postValue(throwable.localizedMessage)
                }
            })
        }
    }
}