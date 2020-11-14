package com.hellohasan.google_map.feature.home.presenter

import android.location.Location
import com.hellohasan.google_map.core.DataFetchCallback
import com.hellohasan.google_map.feature.home.model.LocationData
import com.hellohasan.google_map.feature.home.model.MainActivityModel
import com.hellohasan.google_map.feature.home.view.MainActivityView

class MainActivityPresenterImpl (private var view: MainActivityView?, private val model: MainActivityModel) : MainActivityPresenter {

    override fun getCurrentLocation() {

        model.getCurrentLocation(object : DataFetchCallback<Location> {

            override fun onSuccess(data: Location) {
                val locationData = LocationData(data.latitude, data.longitude)
                view?.onLocationFetchSuccess(locationData)
            }

            override fun onError(throwable: Throwable) {
                throwable.localizedMessage?.let {
                    view?.onLocationError(it)
                }
            }
        })
    }

    override fun detachView() {
        view = null
    }
}