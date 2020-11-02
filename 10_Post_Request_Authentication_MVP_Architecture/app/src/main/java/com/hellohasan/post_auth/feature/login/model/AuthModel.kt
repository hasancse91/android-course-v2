package com.hellohasan.post_auth.feature.login.model

interface AuthModel {
    fun login(userCredential: UserCredential, callback: ApiCallback<LoginResponse>)
}