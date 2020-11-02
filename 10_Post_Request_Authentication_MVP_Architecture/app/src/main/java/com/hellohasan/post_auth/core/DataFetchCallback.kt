package com.hellohasan.post_auth.core

interface DataFetchCallback<T> {
    fun onSuccess(data: T)
    fun onError(throwable: Throwable)
}