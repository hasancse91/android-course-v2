package com.hellohasan.fragment_navigation_drawer.feature.home.presenter

import com.hellohasan.fragment_navigation_drawer.core.DataFetchCallback
import com.hellohasan.fragment_navigation_drawer.feature.home.model.CourseInfoResponse
import com.hellohasan.fragment_navigation_drawer.feature.home.model.HomeModel
import com.hellohasan.fragment_navigation_drawer.feature.home.model.HomeModelImpl
import com.hellohasan.fragment_navigation_drawer.feature.home.view.HomeView
import com.orhanobut.logger.Logger

class HomePresenterImpl (private val view: HomeView) : HomePresenter {

    private val model : HomeModel = HomeModelImpl()

    override fun getCourseInformation() {

        view.setProgressBarVisibility(true)

        model.getCourseInformation(object : DataFetchCallback<CourseInfoResponse> {

            override fun onSuccess(data: CourseInfoResponse) {
                view.setProgressBarVisibility(false)
                data.data?.let {
                    view.onDataFetchSuccess(it)
                }
            }

            override fun onError(throwable: Throwable) {
                view.setProgressBarVisibility(false)
                throwable.localizedMessage?.let {
                    view.onDataFetchFailure(it)
                }
            }
        })
    }

}