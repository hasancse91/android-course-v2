package com.hellohasan.fragment_navigation_drawer.feature.home.view

import com.hellohasan.fragment_navigation_drawer.feature.home.model.CourseInfoResponse

interface HomeView {
    fun setProgressBarVisibility(isVisible: Boolean)
    fun onDataFetchSuccess(data: CourseInfoResponse.Data)
    fun onDataFetchFailure(errorMessage: String)
}