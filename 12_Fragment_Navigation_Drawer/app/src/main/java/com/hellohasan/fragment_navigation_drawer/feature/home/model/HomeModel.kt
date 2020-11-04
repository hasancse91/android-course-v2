package com.hellohasan.fragment_navigation_drawer.feature.home.model

import com.hellohasan.fragment_navigation_drawer.core.DataFetchCallback

interface HomeModel {
    fun getCourseInformation(callback: DataFetchCallback<CourseInfoResponse>)
}