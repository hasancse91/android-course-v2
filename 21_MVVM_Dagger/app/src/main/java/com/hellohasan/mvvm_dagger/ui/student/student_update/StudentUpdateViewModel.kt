package com.hellohasan.mvvm_dagger.ui.student.student_update

import androidx.lifecycle.viewModelScope
import com.hellohasan.mvvm_dagger.core.BaseViewModel
import com.hellohasan.mvvm_dagger.core.DataFetchCallback
import com.hellohasan.mvvm_dagger.data.repository.student.Student
import com.hellohasan.mvvm_dagger.data.repository.student.StudentRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

class StudentUpdateViewModel @Inject constructor(private val repository: StudentRepository): BaseViewModel() {

    fun updateStudentRecord(student: Student) {

        viewModelScope.launch {
            repository.updateStudent(student, object : DataFetchCallback<Int> {
                override fun onSuccess(data: Int) {
                    TODO("Not yet implemented")
                }

                override fun onError(throwable: Throwable) {
                    TODO("Not yet implemented")
                }

            })
        }
    }
}