package com.hellohasan.mvvm_food_app.feature.food_list.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.hellohasan.mvvm_food_app.R
import com.hellohasan.mvvm_food_app.core.BaseActivity
import com.hellohasan.mvvm_food_app.core.ListItemClickListener
import com.hellohasan.mvvm_food_app.feature.food_details.model.Food
import com.hellohasan.mvvm_food_app.feature.food_details.view.FoodDetailsActivity
import com.hellohasan.mvvm_food_app.feature.food_list.model.FoodListModel
import com.hellohasan.mvvm_food_app.feature.food_list.model.FoodListModelImpl
import com.hellohasan.mvvm_food_app.feature.food_list.viewmodel.FoodListViewModel
import kotlinx.android.synthetic.main.activity_food_list.*
import kotlinx.android.synthetic.main.toolbar.*

class FoodListActivity : BaseActivity() {

    private lateinit var model: FoodListModel
    private lateinit var viewModel: FoodListViewModel

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

        model = FoodListModelImpl()
        viewModel = ViewModelProvider(this).get(FoodListViewModel::class.java)

        viewModel.getFoodList(model)

        viewModel.progressBarVisibility.observe(this, {
            progress.visibility = if (it) View.VISIBLE else View.GONE
        })

        viewModel.foodListLiveData.observe(this, {
            initFoodAdapter(it)
        })

        viewModel.foodListErrorLiveData.observe(this, {
            showToast(it)
        })
    }

    private fun initFoodAdapter(foodList: MutableList<Food>) {

        val adapter = FoodListAdapter(foodList, object : ListItemClickListener {

            override fun onItemClicked(position: Int) {
                startActivity(Intent(this@FoodListActivity, FoodDetailsActivity::class.java))
            }

        })
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView.adapter = adapter
    }

}