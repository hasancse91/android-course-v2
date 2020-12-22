package com.hellohasan.mvp_architecture.feature.food_details.view

import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import com.bumptech.glide.Glide
import com.hellohasan.mvp_architecture.R

import com.hellohasan.mvp_architecture.core.BaseActivity
import com.hellohasan.mvp_architecture.feature.food_details.model.Food
import com.hellohasan.mvp_architecture.feature.food_details.presenter.FoodDetailsPresenter
import com.hellohasan.mvp_architecture.feature.food_details.presenter.FoodDetailsPresenterImpl
import com.orhanobut.logger.Logger
import kotlinx.android.synthetic.main.activity_food_details.*
import kotlinx.android.synthetic.main.toolbar.*

class FoodDetailsActivity : BaseActivity(), FoodDetailsView {

    override fun setLayoutId(): Int = R.layout.activity_food_details
    override fun setToolbar(): Toolbar {
        toolbar.title = getString(R.string.title_food_details_page)
        return toolbar
    }
    override val isHomeUpButtonEnable: Boolean get() = true

    private lateinit var presenter : FoodDetailsPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        presenter = FoodDetailsPresenterImpl(this)

        presenter.getFoodDetails()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.detachView()
    }

    override fun handleProgressBarVisibility(visibility: Int) {
        progressBar.visibility = visibility
    }

    override fun onFoodDetailsFetchSuccess(food: Food) {

        Glide.with(iv_food)
                .load(food.imageUrl)
                .into(iv_food)
        tv_food_name.text = food.name
        tv_price_value.text = getString(R.string.price_format, food.price)
        tv_description.text = food.description
    }

    override fun onFoodDetailsFetchFailure(errorMessage: String) {

        showToast(errorMessage)

        Logger.e(errorMessage)
    }

}