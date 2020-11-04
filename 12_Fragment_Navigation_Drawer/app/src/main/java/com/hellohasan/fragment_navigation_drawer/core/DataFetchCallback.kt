package com.hellohasan.fragment_navigation_drawer.core

interface DataFetchCallback<T> {
    fun onSuccess(data: T)
    fun onError(throwable: Throwable)
}