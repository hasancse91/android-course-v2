package com.hellohasan.google_map.feature.home.presenter

import android.location.Location
import com.hellohasan.google_map.core.DataFetchCallback
import com.hellohasan.google_map.core.toHumanReadableDateFormat
import com.hellohasan.google_map.core.toLocationData
import com.hellohasan.google_map.feature.home.model.LocationData
import com.hellohasan.google_map.feature.home.model.MainActivityModel
import com.hellohasan.google_map.feature.home.view.MainActivityView

class MainActivityPresenterImpl (private var view: MainActivityView?, private val model: MainActivityModel) : MainActivityPresenter {

    override fun getCurrentLocation() {

        model.getCurrentLocation(object : DataFetchCallback<Location> {

            override fun onSuccess(data: Location) {
                view?.onLocationFetchSuccess(data.toLocationData())
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