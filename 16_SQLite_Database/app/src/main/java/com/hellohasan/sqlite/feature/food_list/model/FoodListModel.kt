package com.hellohasan.sqlite.feature.food_list.model

import com.hellohasan.sqlite.core.DataFetchCallback
import com.hellohasan.sqlite.feature.food_details.model.Food

interface FoodListModel {
    fun getFoodList(callback: DataFetchCallback<MutableList<Food>>)
}