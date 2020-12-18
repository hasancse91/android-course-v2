package com.hellohasan.mvvm_dagger.core

interface DataFetchCallback<T> {
    fun onSuccess(data : T)
    fun onError(throwable: Throwable)
}