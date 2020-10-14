package com.hellohasan.recyclerview.view.home

import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import com.hellohasan.recyclerview.R
import com.hellohasan.recyclerview.core.BaseActivity
import com.hellohasan.recyclerview.model.FoodModel
import com.hellohasan.recyclerview.model.FoodModelImpl
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toolbar.*

class MainActivity : BaseActivity() {

    override fun setLayoutId(): Int = R.layout.activity_main
    override fun setToolbar(): Toolbar {
        toolbar.title = getString(R.string.title_homepage)
        return toolbar
    }

    override val isHomeUpButtonEnable: Boolean get() = false

    private lateinit var foodModel: FoodModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        showFoodList()
    }

    private fun showFoodList() {
        foodModel = FoodModelImpl()

        val foodList = foodModel.getFoodList()

        val adapter = FoodListAdapter(foodList, object : FoodItemClickListener {

            override fun onItemClicked(position: Int) {
                showToast(foodList[position].name)
            }

            override fun onFavoriteIconClicked(position: Int) {
                showToast(foodList[position].name)
            }

        })

        recyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView.adapter = adapter
    }
}