package com.hellohasan.recyclerview.view.home

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.hellohasan.recyclerview.R
import kotlinx.android.synthetic.main.item_food.view.*

class FoodViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val ivFood: AppCompatImageView = itemView.findViewById(R.id.iv_food)
    val tvFoodName: AppCompatTextView = itemView.findViewById(R.id.tv_food_name)
    val tvPriceValue: AppCompatTextView = itemView.tv_price_value
    val ivFavorite = itemView.iv_favorite as AppCompatImageView // another way of casting
}