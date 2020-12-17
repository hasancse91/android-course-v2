package com.hellohasan.mvvm_dagger.ui.student.student_list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hellohasan.mvvm_dagger.core.DataFetchCallback
import com.hellohasan.mvvm_dagger.data.repository.student.Student
import com.hellohasan.mvvm_dagger.data.repository.student.StudentRepository
import kotlinx.coroutines.launch
import androidx.lifecycle.viewModelScope
import com.hellohasan.mvvm_dagger.core.BaseViewModel
import com.hellohasan.mvvm_dagger.data.repository.client_ip.IpInfo
import com.hellohasan.mvvm_dagger.data.repository.client_ip.IpInfoRepository
import javax.inject.Inject

class StudentListViewModel @Inject constructor(
    private val studentRepository: StudentRepository,
    private val ipInfoRepository: IpInfoRepository
) : BaseViewModel() {

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