package com.hellohasan.fragment_navigation_drawer.feature.login.model


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class LoginResponse(
    @SerializedName("message")
    val message: String?,
    @SerializedName("status")
    val status: Boolean?,
    @SerializedName("token")
    val token: String?
)