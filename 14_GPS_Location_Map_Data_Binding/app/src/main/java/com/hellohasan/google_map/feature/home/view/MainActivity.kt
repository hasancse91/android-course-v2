package com.hellohasan.google_map.feature.home.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.hellohasan.google_map.feature.home.model.LocationData
import com.hellohasan.google_map.R
import com.hellohasan.google_map.core.*
import com.hellohasan.google_map.databinding.ActivityMainBinding
import com.hellohasan.google_map.feature.home.model.MainActivityModelImpl
import com.hellohasan.google_map.feature.home.presenter.MainActivityPresenter
import com.hellohasan.google_map.feature.home.presenter.MainActivityPresenterImpl
import com.hellohasan.google_map.feature.map_view.MapsActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainActivityView {

    private val LOCATION_PERMISSION_REQUEST_CODE = 1698
    lateinit var binding: ActivityMainBinding
    lateinit var presenter: MainActivityPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val model = MainActivityModelImpl(this)
        presenter = MainActivityPresenterImpl(this, model)

        btn_get_location.setOnClickListener {
            findCurrentLocation()
        }

        btn_view_location_on_map.setOnClickListener {
            if (binding.location?.latitude != null && binding.location?.longitude != null) {
                val bundle = Bundle()
                bundle.putDouble(LATITUDE, binding.location!!.latitude)
                bundle.putDouble(LONGITUDE, binding.location!!.longitude)

                val intent = Intent(this, MapsActivity::class.java)
                intent.putExtras(bundle)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Location not found", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onLocationFetchSuccess(locationData: LocationData) {
        binding.location = locationData
    }

    override fun onLocationError(errorMessage: String) {
        Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show()
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if (isLocationPermissionGranted(applicationContext)) {
            presenter.getCurrentLocation()
        }
    }

    private fun findCurrentLocation() {
        if (isLocationPermissionGranted(applicationContext)) {
            presenter.getCurrentLocation()
        } else {
            requestPermission(this, LOCATION_PERMISSION_REQUEST_CODE)
        }
    }
}