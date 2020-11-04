package com.hellohasan.fragment_navigation_drawer.feature.login.model

import android.content.Context
import com.hellohasan.fragment_navigation_drawer.R
import com.hellohasan.fragment_navigation_drawer.core.DataFetchCallback

class AuthModelImpl (private val context: Context) : AuthModel {

    override fun login(userCredential: UserCredential, callback: DataFetchCallback<LoginResponse>) {

        val apiKey = context.getString(R.string.api_key)

    }
}