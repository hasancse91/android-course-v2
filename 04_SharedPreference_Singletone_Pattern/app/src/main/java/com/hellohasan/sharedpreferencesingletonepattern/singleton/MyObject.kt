package com.hellohasan.sharedpreferencesingletonepattern.singleton

object MyObject {

    private var capitalName: String = "Dhaka"

    init {
        print(capitalName)
    }

    fun getCapitalName(): String {
        return capitalName
    }
}