package com.hellohasan.sharedpreferencesingletonepattern.preference

import android.content.Context
import com.hellohasan.sharedpreferencesingletonepattern.preference.AppPreference

class AppPreferenceImpl(context: Context): AppPreference {

    private val sharedPreferences = context.getSharedPreferences("my_app_pref", Context.MODE_PRIVATE)
    private val editor = sharedPreferences.edit()

    override fun getString(key: String): String? {
        return sharedPreferences.getString(key, "")
    }

    override fun setString(key: String, value: String) {
        editor.putString(key, value)
        editor.apply()
    }

    override fun getInt(key: String): Int? {
        return sharedPreferences.getInt(key, -1)
    }

    override fun setInt(key: String, value: Int) {
        editor.putInt(key, value)
        editor.apply()
    }

    override fun getBoolean(key: String): Boolean? {
        return sharedPreferences.getBoolean(key, false)
    }

    override fun setBoolean(key: String, value: Boolean) {
        editor.putBoolean(key, value)
    }
}