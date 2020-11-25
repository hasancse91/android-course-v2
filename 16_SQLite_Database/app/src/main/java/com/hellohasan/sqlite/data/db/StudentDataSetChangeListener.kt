package com.hellohasan.sqlite.data.db

interface StudentDataSetChangeListener {
    fun onStudentDataChanged()
    fun onStudentDataSetChangeError(error: String)
}