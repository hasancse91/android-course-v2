package com.hellohasan.google_map.feature.home.model

import android.annotation.SuppressLint
import android.content.Context
import android.location.Location
import com.google.android.gms.location.LocationServices
import com.hellohasan.google_map.core.DataFetchCallback
import com.hellohasan.google_map.core.isLocationPermissionGranted

class MainActivityModelImpl (private val context: Context) : MainActivityModel {

    @SuppressLint("MissingPermission")
    override fun getCurrentLocation(callback: DataFetchCallback<Location>) {

        if (!isLocationPermissionGranted(context.applicationContext)) {
            callback.onError(Throwable("Location permission is missing"))
            return
        }

        LocationServices.getFusedLocationProviderClient(context)
            .lastLocation
            .addOnSuccessListener { location ->
                if (location != null)
                    callback.onSuccess(location)
                else
                    callback.onError(Throwable("Location not found. Check your Location service and permission"))
            }
            .addOnFailureListener {
                callback.onError(it)
            }
    }
}