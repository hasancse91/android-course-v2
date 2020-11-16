package com.hellohasan.mvvm_food_app.core

interface DataFetchCallback<T> {
    fun onSuccess(data : T)
    fun onError(throwable: Throwable)
}