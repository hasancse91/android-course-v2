package com.hellohasan.recyclerview.view.home

interface FoodItemClickListener {
    fun onItemClicked(position: Int)
    fun onFavoriteIconClicked(position: Int)
}