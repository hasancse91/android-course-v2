package com.hellohasan.retrofitgetrequest.feature.home.model

data class Food (
    val id: Int,
    val name: String,
    val price: Int,
    val isFavorite: Boolean,
    val imageUrl: String,
    val rating: Float,
    val description: String,
    val restaurantName: String
)