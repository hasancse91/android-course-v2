package com.hellohasan.room_orm.core

interface DataFetchCallback<T> {
    fun onSuccess(data : T)
    fun onError(throwable: Throwable)
}