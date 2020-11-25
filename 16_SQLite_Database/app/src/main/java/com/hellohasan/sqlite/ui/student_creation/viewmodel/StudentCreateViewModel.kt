package com.hellohasan.sqlite.ui.student_creation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hellohasan.sqlite.core.DataFetchCallback
import com.hellohasan.sqlite.data.model.student.Student
import com.hellohasan.sqlite.data.model.student.StudentModel

class StudentCreateViewModel(private val model: StudentModel): ViewModel() {

    val studentCreationSuccessLiveData = MutableLiveData<Student>()
    val studentCreationFailedLiveData = MutableLiveData<String>()

    fun createStudent(student: Student) {

        model.insertStudent(student, object : DataFetchCallback<Student> {
            override fun onSuccess(data: Student) {
                studentCreationSuccessLiveData.postValue(data)
            }

            override fun onError(throwable: Throwable) {
                studentCreationFailedLiveData.postValue(throwable.localizedMessage)
            }
        })
    }
}