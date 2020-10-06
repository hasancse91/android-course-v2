package com.hellohasan.sharedpreferencesingletonepattern.data

import android.content.Context
import com.hellohasan.sharedpreferencesingletonepattern.preference.AppPreference
import com.hellohasan.sharedpreferencesingletonepattern.preference.AppPreferenceImpl

class MainActivityModelImpl (context: Context): MainActivityModel {

    private val appPreference = AppPreferenceImpl(context = context)

    override fun getUserName(): String? {
        return appPreference.getString(AppPreference.NAME)
    }

    override fun setUserName(text: String) {
        appPreference.setString(AppPreference.NAME, text)
    }
}