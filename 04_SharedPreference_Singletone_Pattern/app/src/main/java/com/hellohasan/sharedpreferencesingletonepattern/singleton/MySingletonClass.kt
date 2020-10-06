package com.hellohasan.sharedpreferencesingletonepattern.singleton

class MySingletonClass private constructor() {

    private var countryName: String = "Bangladesh"

    init {
        print(countryName)
    }

    companion object {
        private var mySingletonClass: MySingletonClass? = null

        fun getInstance(): MySingletonClass {
            return if (mySingletonClass == null)
                MySingletonClass()
            else
                mySingletonClass!!
        }
    }

    fun getCountryName(): String {
        return countryName
    }
}