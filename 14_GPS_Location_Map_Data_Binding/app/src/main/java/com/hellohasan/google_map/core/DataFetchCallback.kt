package com.hellohasan.google_map.core

interface DataFetchCallback<T> {
    fun onSuccess(data: T)
    fun onError(throwable: Throwable)
}