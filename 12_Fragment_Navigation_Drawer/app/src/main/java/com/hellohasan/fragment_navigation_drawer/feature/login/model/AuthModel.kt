package com.hellohasan.fragment_navigation_drawer.feature.login.model

import com.hellohasan.fragment_navigation_drawer.core.DataFetchCallback

interface AuthModel {
    fun login(userCredential: UserCredential, callback: DataFetchCallback<LoginResponse>)
}