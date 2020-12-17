package com.hellohasan.mvvm_dagger.ui.subject

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.hellohasan.mvvm_dagger.core.BaseViewModel
import com.hellohasan.mvvm_dagger.core.DataFetchCallback
import com.hellohasan.mvvm_dagger.data.repository.subject.Subject
import com.hellohasan.mvvm_dagger.data.repository.subject.SubjectRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

class SubjectViewModel @Inject constructor(private val repository: SubjectRepository) : BaseViewModel() {

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