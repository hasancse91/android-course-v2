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
import com.hellohasan.a09_android_mvp_architecture.feature.food_list.model.FoodListModel
import com.hellohasan.a09_android_mvp_architecture.feature.food_list.model.FoodListModelImpl
import com.hellohasan.a09_android_mvp_architecture.feature.food_list.presenter.FoodListPresenter
import com.hellohasan.a09_android_mvp_architecture.feature.food_list.presenter.FoodListPresenterImpl
import kotlinx.android.synthetic.main.activity_food_list.*
import kotlinx.android.synthetic.main.toolbar.*

class FoodListActivity : BaseActivity(), FoodListView {

    override fun setLayoutId(): Int {
        return R.layout.activity_food_list
    }
    override fun setToolbar(): Toolbar {
        toolbar.title = getString(R.string.title_food_list)
        return toolbar
    }
    override val isHomeUpButtonEnable: Boolean get() = false

    private lateinit var presenter: FoodListPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        presenter = FoodListPresenterImpl(this)

        presenter.getFoodList()
    }

    override fun handleProgressBarVisibility(isVisible: Boolean) {
        if (isVisible)
            progress.visibility = View.VISIBLE
        else
            progress.visibility = View.GONE
    }

    override fun onFoodListFetchSuccess(foodList: MutableList<Food>) {
        initFoodAdapter(foodList)
    }

    override fun onFoodListFetchFailure(errorMessage: String) {
        showToast(errorMessage)
    }

    private fun initFoodAdapter(foodList: MutableList<Food>) {

        val adapter = FoodListAdapter(foodList, object : ItemClickListener {

            override fun onItemClicked(position: Int) {
                startActivity(Intent(this@FoodListActivity, FoodDetailsActivity::class.java))
            }

        })
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView.adapter = adapter
    }

}