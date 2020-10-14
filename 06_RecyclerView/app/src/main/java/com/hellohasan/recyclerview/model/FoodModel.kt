package com.hellohasan.recyclerview.model

interface FoodModel {
    fun getFoodList(): MutableList<Food>
    fun getFoodItemById(id: Int): Food
}