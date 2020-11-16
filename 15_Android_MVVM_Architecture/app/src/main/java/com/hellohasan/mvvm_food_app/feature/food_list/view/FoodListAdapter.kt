package com.hellohasan.mvvm_food_app.feature.food_list.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.hellohasan.mvvm_food_app.R
import com.hellohasan.mvvm_food_app.core.ListItemClickListener
import com.hellohasan.mvvm_food_app.feature.food_details.model.Food

class FoodListAdapter(val foodList: MutableList<Food>, val listItemClickListener: ListItemClickListener) : RecyclerView.Adapter<FoodViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_food, parent, false)
        return FoodViewHolder(view)
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        val food = foodList[position]

        Glide.with(holder.iv_food)
            .load(food.imageUrl)
            .into(holder.iv_food)
        holder.tv_food_name.text = food.name
        holder.tv_price_value.text = holder.itemView.context.getString(R.string.price_format, food.price)

        holder.itemView.setOnClickListener {
            listItemClickListener.onItemClicked(position)
        }
    }

    override fun getItemCount(): Int {
        return foodList.size
    }

}