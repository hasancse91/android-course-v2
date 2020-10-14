package com.hellohasan.recyclerview.view.home

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.hellohasan.recyclerview.R
import com.hellohasan.recyclerview.model.Food

class FoodListAdapter(
    private val foodList: MutableList<Food>,
    private val clickListener: FoodItemClickListener
) : RecyclerView.Adapter<FoodViewHolder>() {

    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        context = parent.context

        val view = LayoutInflater.from(context).inflate(R.layout.item_food, parent, false)

        return FoodViewHolder(view)
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {

        val food = foodList[position]

        Glide.with(context)
            .load(food.imageUrl)
            .into(holder.ivFood)

        holder.tvFoodName.text = food.name
        holder.tvPriceValue.text = context.getString(R.string.price_format, food.price)

        val favoriteImageDrawableId =
            if (food.isFavorite) R.drawable.ic_baseline_favorite_24 else R.drawable.ic_baseline_favorite_border_24

        holder.ivFavorite.setImageDrawable(
            ContextCompat.getDrawable(
                context,
                favoriteImageDrawableId
            )
        )

        holder.itemView.setOnClickListener {
            clickListener.onItemClicked(position)
        }

        holder.ivFavorite.setOnClickListener {
            clickListener.onFavoriteIconClicked(position)
        }
    }

    override fun getItemCount(): Int {
        return foodList.size
    }
}