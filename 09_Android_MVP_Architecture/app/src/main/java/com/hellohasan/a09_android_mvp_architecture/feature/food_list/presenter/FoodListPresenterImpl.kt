package com.hellohasan.a09_android_mvp_architecture.feature.food_list.presenter

import com.hellohasan.a09_android_mvp_architecture.feature.food_details.model.Food
import com.hellohasan.a09_android_mvp_architecture.feature.food_list.model.FoodListModel
import com.hellohasan.a09_android_mvp_architecture.feature.food_list.model.FoodListModelImpl
import com.hellohasan.a09_android_mvp_architecture.feature.food_list.view.FoodListView
import com.hellohasan.retrofitgetrequest.feature.food_list.model.FoodListCallback

class FoodListPresenterImpl(private var view: FoodListView?): FoodListPresenter {

    private val model: FoodListModel = FoodListModelImpl()

    override fun getFoodList() {

        view?.handleProgressBarVisibility(true)

        model.getFoodList(object : FoodListCallback {

            override fun onSuccess(foodList: MutableList<Food>) {
                view?.handleProgressBarVisibility(false)
                view?.onFoodListFetchSuccess(foodList)
            }

            override fun onError(throwable: Throwable) {
                view?.handleProgressBarVisibility(false)
                if (throwable.localizedMessage != null)
                    view?.onFoodListFetchFailure(throwable.localizedMessage!!)
                else
                    view?.onFoodListFetchFailure("Something went wrong")
            }

        })
    }

    override fun detachView() {
        view = null
    }
}