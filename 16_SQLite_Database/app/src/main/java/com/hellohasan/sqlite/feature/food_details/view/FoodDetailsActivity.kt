package com.hellohasan.sqlite.feature.food_details.view

import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.hellohasan.sqlite.R

import com.hellohasan.sqlite.core.BaseActivity
import com.hellohasan.sqlite.feature.food_details.model.FoodDetailsModel
import com.hellohasan.sqlite.feature.food_details.model.FoodDetailsModelImpl
import com.hellohasan.sqlite.feature.food_details.viewmodel.FoodDetailsViewModel
import com.hellohasan.sqlite.feature.food_details.viewmodel.FoodDetailsViewModelFactory
import com.orhanobut.logger.Logger
import kotlinx.android.synthetic.main.activity_food_details.*
import kotlinx.android.synthetic.main.toolbar.*

class FoodDetailsActivity : BaseActivity() {

    private lateinit var model: FoodDetailsModel
    private lateinit var viewModel: FoodDetailsViewModel

    override fun setLayoutId(): Int = R.layout.activity_food_details
    override fun setToolbar(): Toolbar {
        toolbar.title = getString(R.string.title_food_details_page)
        return toolbar
    }
    override val isHomeUpButtonEnable: Boolean get() = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        model = FoodDetailsModelImpl()
        val factory = FoodDetailsViewModelFactory(model)
        viewModel = ViewModelProvider(this, factory).get(FoodDetailsViewModel::class.java)

        viewModel.getFoodDetails()

        viewModel.progressBarVisibility.observe(this, {
            progressBar.visibility = if (it) View.VISIBLE else View.GONE
        })

        viewModel.foodDetailsLiveData.observe(this, { food ->
            Glide.with(iv_food)
                    .load(food.imageUrl)
                    .into(iv_food)
            tv_food_name.text = food.name
            tv_price_value.text = getString(R.string.price_format, food.price)
            tv_description.text = food.description
        })

        viewModel.foodDetailsErrorLiveData.observe(this, {
            showToast(it)

            Logger.e(it)
        })
    }

}