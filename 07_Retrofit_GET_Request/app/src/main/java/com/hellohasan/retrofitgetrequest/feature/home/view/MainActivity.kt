package com.hellohasan.retrofitgetrequest.feature.home.view

import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.Toolbar
import com.hellohasan.retrofitgetrequest.R
import com.hellohasan.retrofitgetrequest.core.BaseActivity
import com.hellohasan.retrofitgetrequest.feature.home.model.Food
import com.hellohasan.retrofitgetrequest.feature.home.model.FoodCallback
import com.hellohasan.retrofitgetrequest.feature.home.model.HomeModelImpl
import com.orhanobut.logger.Logger
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toolbar.*

class MainActivity : BaseActivity() {

    override fun setLayoutId(): Int = R.layout.activity_main
    override fun setToolbar(): Toolbar {
        toolbar.title = getString(R.string.title_homepage)
        return toolbar
    }
    override val isHomeUpButtonEnable: Boolean get() = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        showFoodDetails()
    }

    private fun showFoodDetails() {

        progressBar.visibility = View.VISIBLE

        val homeModel = HomeModelImpl()

        homeModel.getFoodDetails(object : FoodCallback{
            override fun onSuccess(food: Food) {
                progressBar.visibility = View.GONE
                Logger.d(food.toString())
            }

            override fun onError(errorMessage: Throwable) {
                progressBar.visibility = View.GONE
                Logger.e(errorMessage.localizedMessage)
            }
        })
    }
}