package com.hellohasan.post_auth.feature.login.model

interface ApiCallback<T> {
    fun onSuccess(data: T)
    fun onError(throwable: Throwable)
}