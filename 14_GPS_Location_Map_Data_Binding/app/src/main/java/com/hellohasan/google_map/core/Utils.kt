package com.hellohasan.google_map.core

import android.location.Location
import com.hellohasan.google_map.feature.home.model.LocationData

fun Location.toLocationData() : LocationData {
    return LocationData(latitude, this.longitude)
}