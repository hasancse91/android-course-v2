package com.hellohasan.sqlite.feature.food_details.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Food (
    val id: Int,
    val name: String,
    val price: Int,
    val discount: Int,
    val isFavorite: Boolean,
    val imageUrl: String,
    val rating: Float,
    val description: String,
    @SerializedName("restaurantName") val restaurant: String
): Serializable