package com.hellohasan.mvvm_dagger.data.local.preference

interface AppPreference {

    companion object {
        const val IP_ADDRESS = "ip-address"
        const val IP_TYPE = "ip-type"
    }

    fun getString(key: String): String
    fun setString(key: String, value: String)
    fun getInt(key: String): Int
    fun setInt(key: String, value: Int)
    fun getBoolean(key: String): Boolean
    fun setBoolean(key: String, value: Boolean)
}