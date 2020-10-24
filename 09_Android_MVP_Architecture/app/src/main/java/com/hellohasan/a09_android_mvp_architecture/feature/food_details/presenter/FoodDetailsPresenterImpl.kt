package com.hellohasan.a09_android_mvp_architecture.feature.food_details.presenter

import com.hellohasan.a09_android_mvp_architecture.feature.food_details.model.Food
import com.hellohasan.a09_android_mvp_architecture.feature.food_details.model.FoodCallback
import com.hellohasan.a09_android_mvp_architecture.feature.food_details.model.FoodDetailsModel
import com.hellohasan.a09_android_mvp_architecture.feature.food_details.model.FoodDetailsModelImpl
import com.hellohasan.a09_android_mvp_architecture.feature.food_details.view.FoodDetailsView

class FoodDetailsPresenterImpl(private val view: FoodDetailsView): FoodDetailsPresenter {

    val model : FoodDetailsModel = FoodDetailsModelImpl()

    override fun getFoodDetails() {

        model.getFoodDetails(object : FoodCallback{

            override fun onSuccess(food: Food) {
                view.onFoodDetailsFetchSuccess(food)
            }

            override fun onError(errorMessage: Throwable) {
                if (errorMessage.localizedMessage != null)
                    view.onFoodDetailsFetchFailure(errorMessage.localizedMessage!!)
                else
                    view.onFoodDetailsFetchFailure("Something went wrong!")
            }

        })
    }
}