package com.hellohasan.post_auth.feature.login.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class UserCredential (
    @SerializedName("user_id") val userId: String,
    val password: String
): Serializable