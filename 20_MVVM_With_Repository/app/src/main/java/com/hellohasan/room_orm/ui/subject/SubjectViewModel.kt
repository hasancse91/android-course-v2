package com.hellohasan.room_orm.ui.subject

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hellohasan.room_orm.core.DataFetchCallback
import com.hellohasan.room_orm.data.repository.subject.Subject
import com.hellohasan.room_orm.data.repository.subject.SubjectRepository
import kotlinx.coroutines.launch

class SubjectViewModel(private val repository: SubjectRepository) : ViewModel() {

    val subjectCreationSuccessLiveData = MutableLiveData<Unit>()
    val subjectCreationFailedLiveData = MutableLiveData<String>()

    fun createSubject(subject: Subject, studentRegistrationNumber: Long) {

        viewModelScope.launch {

            repository.createSubject(subject, object : DataFetchCallback<Long> {

                    override fun onSuccess(data: Long) {
                        subjectCreationSuccessLiveData.postValue(Unit)
                    }

                    override fun onError(throwable: Throwable) {
                        subjectCreationFailedLiveData.postValue(throwable.localizedMessage)
                    }
                }
            )
        }

    }
}