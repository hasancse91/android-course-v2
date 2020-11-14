package com.hellohasan.google_map.feature.home.view

import com.hellohasan.google_map.feature.home.model.LocationData

interface MainActivityView {
    fun onLocationFetchSuccess(locationData: LocationData)
    fun onLocationError(errorMessage: String)
}