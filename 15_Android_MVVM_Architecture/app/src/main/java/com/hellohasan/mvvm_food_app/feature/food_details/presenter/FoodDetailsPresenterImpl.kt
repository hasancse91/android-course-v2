package com.hellohasan.mvvm_food_app.feature.food_details.presenter

import com.hellohasan.mvvm_food_app.feature.food_details.model.Food
import com.hellohasan.mvvm_food_app.feature.food_details.model.FoodCallback
import com.hellohasan.mvvm_food_app.feature.food_details.model.FoodDetailsModel
import com.hellohasan.mvvm_food_app.feature.food_details.model.FoodDetailsModelImpl
import com.hellohasan.mvvm_food_app.feature.food_details.view.FoodDetailsView

class FoodDetailsPresenterImpl(private var view: FoodDetailsView?): FoodDetailsPresenter {

    val model : FoodDetailsModel = FoodDetailsModelImpl()
    val VISIBLE = 0 // View.VISIBLE = 0
    val GONE = 8 // View.GONE = 8

    override fun getFoodDetails() {

        view?.handleProgressBarVisibility(VISIBLE)

        model.getFoodDetails(object : FoodCallback {

            override fun onSuccess(food: Food) {
                view?.handleProgressBarVisibility(GONE)
                view?.onFoodDetailsFetchSuccess(food)
            }

            override fun onError(errorMessage: Throwable) {
                view?.handleProgressBarVisibility(VISIBLE)
                if (errorMessage.localizedMessage != null)
                    view?.onFoodDetailsFetchFailure(errorMessage.localizedMessage!!)
                else
                    view?.onFoodDetailsFetchFailure("Something went wrong!")
            }
        })
    }

    override fun detachView() {
        view = null
    }
}