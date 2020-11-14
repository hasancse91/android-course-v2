package com.hellohasan.google_map.feature.home.model

import android.location.Location
import com.hellohasan.google_map.core.DataFetchCallback

interface MainActivityModel {
    fun getCurrentLocation(callback: DataFetchCallback<Location>)
}