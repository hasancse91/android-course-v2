package com.hellohasan.post_auth.feature.login.model

import com.hellohasan.post_auth.core.DataFetchCallback

interface AuthModel {
    fun login(userCredential: UserCredential, callback: DataFetchCallback<LoginResponse>)
}