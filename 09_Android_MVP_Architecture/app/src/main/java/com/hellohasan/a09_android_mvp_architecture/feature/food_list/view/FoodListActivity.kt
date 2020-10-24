package com.hellohasan.a09_android_mvp_architecture.feature.food_list.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import com.hellohasan.a09_android_mvp_architecture.R
import com.hellohasan.a09_android_mvp_architecture.core.BaseActivity
import com.hellohasan.a09_android_mvp_architecture.feature.food_details.model.Food
import com.hellohasan.a09_android_mvp_architecture.feature.food_details.view.FoodDetailsActivity
import com.hellohasan.retrofitgetrequest.feature.food_list.model.FoodListCallback
import com.hellohasan.retrofitgetrequest.feature.food_list.model.FoodListModel
import com.hellohasan.retrofitgetrequest.feature.food_list.model.FoodListModelImpl
import kotlinx.android.synthetic.main.activity_food_list.*
import kotlinx.android.synthetic.main.toolbar.*

class FoodListActivity : BaseActivity() {

    override fun setLayoutId(): Int {
        return R.layout.activity_food_list
    }

    override fun setToolbar(): Toolbar {
        toolbar.title = getString(R.string.title_food_list)
        return toolbar
    }

    override val isHomeUpButtonEnable: Boolean get() = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        showFoodList()

    }

    private fun showFoodList() {
        progress.visibility = View.VISIBLE
        val foodListModel: FoodListModel = FoodListModelImpl()

        foodListModel.getFoodList(object : FoodListCallback {

            override fun onSuccess(foodList: MutableList<Food>) {
                progress.visibility = View.GONE
                initFoodAdapter(foodList)
            }

            override fun onError(throwable: Throwable) {
                progress.visibility = View.GONE
                showToast(throwable.localizedMessage)
            }

        })
    }

    private fun initFoodAdapter(foodList: MutableList<Food>) {

        val adapter = FoodListAdapter(foodList, object : ItemClickListener {

            override fun onItemClicked(position: Int) {
                startActivity(Intent(this@FoodListActivity, FoodDetailsActivity::class.java))
            }

        })
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView.adapter = adapter

//        val funClass = FunClass()
//        val adapter = FoodListAdapter(foodList, funClass)
    }

//    class FunClass: ItemClickListener {
//
//        override fun onItemClicked(position: Int) {
//
//        }
//    }
}