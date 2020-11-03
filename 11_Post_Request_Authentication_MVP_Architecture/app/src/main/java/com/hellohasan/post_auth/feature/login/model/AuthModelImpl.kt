package com.hellohasan.post_auth.feature.login.model

import android.content.Context
import com.hellohasan.post_auth.R
import com.hellohasan.post_auth.core.DataFetchCallback

class AuthModelImpl (private val context: Context) : AuthModel {

    override fun login(userCredential: UserCredential, callback: DataFetchCallback<LoginResponse>) {

        val apiKey = context.getString(R.string.api_key)

    }
}