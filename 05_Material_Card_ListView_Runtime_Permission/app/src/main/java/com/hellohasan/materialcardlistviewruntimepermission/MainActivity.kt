package com.hellohasan.materialcardlistviewruntimepermission

import android.Manifest.permission.CALL_PHONE
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.hellohasan.materialcardlistviewruntimepermission.core.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    private var phoneNumber = "01521101145"
    private val PHONE_CALL_PERMISSION_REQUEST_CODE = 12598

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_phone_call.setOnClickListener {
            callTheDeveloper()
        }

        val listData = getListData()

        val adapter: ArrayAdapter<String> = ArrayAdapter<String>(
            this,
            android.R.layout.simple_list_item_1,
            listData
        )
        listView.adapter = adapter
        listView.setOnItemClickListener { parent, view, position, id ->
            showToast(listData[position])
        }

    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if (requestCode == PHONE_CALL_PERMISSION_REQUEST_CODE) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                callTheDeveloper()
            }
        }

    }

    private fun callTheDeveloper() {
        if (isPermissionGranted()) {
            val callIntent = Intent(Intent.ACTION_CALL)
            callIntent.data = Uri.parse("tel:$phoneNumber")
            startActivity(callIntent)
        } else {
            requestPermission()
        }
    }

    private fun isPermissionGranted(): Boolean {
        return ContextCompat.checkSelfPermission(applicationContext, CALL_PHONE) == PackageManager.PERMISSION_GRANTED
    }

    private fun requestPermission() {
        ActivityCompat.requestPermissions(
            this,
            arrayOf(CALL_PHONE),
            PHONE_CALL_PERMISSION_REQUEST_CODE
        )
    }

    private fun getListData(): Array<String> {
        return arrayOf(
            "Apple",
            "Orange",
            "Lemon",
            "Apple",
            "Orange",
            "Lemon",
            "Apple",
            "Orange",
            "Lemon",
            "Apple",
            "Orange",
            "Lemon",
            "Apple",
            "Orange",
            "Lemon"
        )
    }
}