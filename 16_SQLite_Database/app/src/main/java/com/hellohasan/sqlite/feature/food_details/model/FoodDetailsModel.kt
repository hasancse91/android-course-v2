package com.hellohasan.sqlite.feature.food_details.model

import com.hellohasan.sqlite.core.DataFetchCallback

interface FoodDetailsModel {
    fun getFoodDetails(callback: DataFetchCallback<Food>)
}