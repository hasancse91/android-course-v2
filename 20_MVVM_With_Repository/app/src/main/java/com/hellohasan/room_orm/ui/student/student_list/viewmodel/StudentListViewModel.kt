package com.hellohasan.room_orm.ui.student.student_list.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hellohasan.room_orm.core.DataFetchCallback
import com.hellohasan.room_orm.data.repository.student.Student
import com.hellohasan.room_orm.data.repository.student.StudentRepository
import kotlinx.coroutines.launch
import androidx.lifecycle.viewModelScope
import com.hellohasan.room_orm.data.repository.client_ip.IpInfo
import com.hellohasan.room_orm.data.repository.client_ip.IpInfoRepository

class StudentListViewModel(
    private val studentRepository: StudentRepository,
    private val ipInfoRepository: IpInfoRepository
) : ViewModel() {

    val ipInfoLiveData = MutableLiveData<String>()
    val studentListLiveData = MutableLiveData<MutableList<Student>>()
    val studentListFailedLiveData = MutableLiveData<String>()
    val studentDeletionSuccessLiveData = MutableLiveData<Unit>()
    val studentDeletionFailedLiveData = MutableLiveData<String>()

    fun getIpInfo() {

        ipInfoRepository.getClientInfo(object : DataFetchCallback<IpInfo> {
            override fun onSuccess(data: IpInfo) {
                ipInfoLiveData.postValue(data.toString())
            }

            override fun onError(throwable: Throwable) {
                ipInfoLiveData.postValue(throwable.message)
            }
        })
    }

    fun getStudentList() {

        viewModelScope.launch {
            studentRepository.getStudentList(object : DataFetchCallback<MutableList<Student>> {

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
            studentRepository.deleteStudent(student, object : DataFetchCallback<Int> {
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