package com.hellohasan.sharedpreferencesingletonepattern.preference

interface AppPreference {

    companion object {
        const val NAME = "name"
        const val AGE = "age"
        const val IS_STUDENT = "is_student"
    }

    fun getString(key: String): String?
    fun setString(key: String, value: String)
    fun getInt(key: String): Int?
    fun setInt(key: String, value: Int)
    fun getBoolean(key: String): Boolean?
    fun setBoolean(key: String, value: Boolean)
}