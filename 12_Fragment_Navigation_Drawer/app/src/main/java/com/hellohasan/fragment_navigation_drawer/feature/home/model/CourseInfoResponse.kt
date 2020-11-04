package com.hellohasan.fragment_navigation_drawer.feature.home.model

import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class CourseInfoResponse(
    @SerializedName("data")
    val `data`: Data?,
    @SerializedName("message")
    val message: String?,
    @SerializedName("status")
    val status: Boolean?
) {
    @Keep
    data class Data(
        @SerializedName("class_days")
        val classDays: List<String?>?,
        @SerializedName("class_duration")
        val classDuration: String?,
        @SerializedName("duration")
        val duration: String?,
        @SerializedName("fee")
        val fee: String?,
        @SerializedName("image")
        val image: String?,
        @SerializedName("name")
        val name: String?,
        @SerializedName("number_of_class")
        val numberOfClass: Int?,
        @SerializedName("url")
        val url: String?
    )
}