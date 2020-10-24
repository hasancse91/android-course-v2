package com.hellohasan.a09_android_mvp_architecture.feature.food_list.view

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_food.view.*

class FoodViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val iv_food : ImageView = itemView.iv_food
    val tv_food_name: TextView = itemView.tv_food_name
    val tv_price_value : TextView = itemView.tv_price_value
    val iv_favorite : ImageView = itemView.iv_favorite
}