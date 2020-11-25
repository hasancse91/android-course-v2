package com.hellohasan.a09_android_mvp_architecture.feature.food_list.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
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
import com.hellohasan.a09_android_mvp_architecture.feature.food_list.viewmodel.FoodListViewModel
import kotlinx.android.synthetic.main.activity_food_details.*
import kotlinx.android.synthetic.main.activity_food_list.*
import kotlinx.android.synthetic.main.toolbar.*

class FoodListActivity : BaseActivity() {

    private lateinit var viewModel: FoodListViewModel
    private lateinit var model : FoodListModel

    override fun getParentActivityIntent(): Intent? {
        return super.getParentActivityIntent()
    }

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

        viewModel.foodListLiveData.observe(this, {
            initFoodAdapter(it)
        })

        viewModel.progressBarVisibility.observe(this, {
            progressBar.visibility = if (it) View.VISIBLE else View.GONE
        })

        viewModel.foodListErrorLiveData.observe(this, { errorMessage ->
            showToast(errorMessage)
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
    }
}