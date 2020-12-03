package com.hellohasan.room_orm.ui.student.student_list.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hellohasan.room_orm.core.DataFetchCallback
import com.hellohasan.room_orm.data.repository.student.Student
import com.hellohasan.room_orm.data.repository.student.StudentRepository
import kotlinx.coroutines.launch
import androidx.lifecycle.viewModelScope

class StudentListViewModel(private val repository: StudentRepository) : ViewModel() {

    val studentListLiveData = MutableLiveData<MutableList<Student>>()
    val studentListFailedLiveData = MutableLiveData<String>()
    val studentDeletionSuccessLiveData = MutableLiveData<Unit>()
    val studentDeletionFailedLiveData = MutableLiveData<String>()

    fun getStudentList() {

        viewModelScope.launch {
            repository.getStudentList(object : DataFetchCallback<MutableList<Student>> {

                override fun onSuccess(data: MutableList<Student>) {
                    studentListLiveData.postValue(data)
                }

                override fun onError(throwable: Throwable) {
                    studentListFailedLiveData.postValue(throwable.localizedMessage)
                }
            })
        }

    }

    fun deleteStudent(student: Student) {

        viewModelScope.launch {
            repository.deleteStudent(student, object : DataFetchCallback<Int> {
                override fun onSuccess(data: Int) {
                    if (data > 0)
                        studentDeletionSuccessLiveData.postValue(Unit)
                    else
                        studentDeletionFailedLiveData.postValue("Failed to delete data")
                }

                override fun onError(throwable: Throwable) {
                    studentDeletionFailedLiveData.postValue(throwable.localizedMessage)
                }
            })
        }
    }
}