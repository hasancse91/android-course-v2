package com.hellohasan.post_auth.feature.student_list.model


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class StudentResponse(
        @SerializedName("data")
    val `data`: List<Data?>?,
        @SerializedName("message")
    val message: String?,
        @SerializedName("status")
    val status: Boolean?
) {
    @Keep
    data class Data(
        @SerializedName("biography")
        val biography: String?,
        @SerializedName("email")
        val email: String?,
        @SerializedName("id")
        val id: Int?,
        @SerializedName("image")
        val image: String?,
        @SerializedName("institution")
        val institution: String?,
        @SerializedName("name")
        val name: String?,
        @SerializedName("phone")
        val phone: String?
    )
}