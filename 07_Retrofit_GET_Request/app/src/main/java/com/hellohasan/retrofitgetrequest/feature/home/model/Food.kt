package com.hellohasan.retrofitgetrequest.feature.home.model

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
    val restaurantName: String
): Serializable