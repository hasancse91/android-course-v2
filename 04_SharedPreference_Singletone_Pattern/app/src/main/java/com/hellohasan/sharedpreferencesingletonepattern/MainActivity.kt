package com.hellohasan.sharedpreferencesingletonepattern

import android.os.Bundle
import android.widget.Toast
import com.hellohasan.sharedpreferencesingletonepattern.core.BaseActivity
import com.hellohasan.sharedpreferencesingletonepattern.data.MainActivityModel
import com.hellohasan.sharedpreferencesingletonepattern.data.MainActivityModelImpl
import com.hellohasan.sharedpreferencesingletonepattern.preference.AppPreference
import com.hellohasan.sharedpreferencesingletonepattern.preference.AppPreferenceImpl
import com.hellohasan.sharedpreferencesingletonepattern.singleton.MyObject
import com.hellohasan.sharedpreferencesingletonepattern.singleton.MySingletonClass
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

//    private lateinit var appPreference: AppPreference
    private lateinit var mainActivityModel: MainActivityModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /**
         * Example of SharedPreference in better way
         */
//        appPreference  = AppPreferenceImpl(this)
//        appPreference.setString(AppPreference.NAME, "John Doe")
//        textView.text = appPreference.getString(AppPreference.NAME)

        mainActivityModel = MainActivityModelImpl(this)
        mainActivityModel.setUserName("John Doe")
        textView.text = mainActivityModel.getUserName()

        /**
         * Example of Singleton pattern
         */
        btn_country_name.setOnClickListener {
            val mySingletonClass = MySingletonClass.getInstance()
            showShortToast("Country: ${mySingletonClass.getCountryName()}")
        }

        btn_capital_name.setOnClickListener {
            val capitalName = MyObject.getCapitalName()
            showLongToast("Capital: $capitalName")
        }
    }

}