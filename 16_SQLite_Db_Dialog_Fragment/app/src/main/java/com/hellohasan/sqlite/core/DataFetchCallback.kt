package com.hellohasan.sqlite.core

interface DataFetchCallback<T> {
    fun onSuccess(data : T)
    fun onError(throwable: Throwable)
}