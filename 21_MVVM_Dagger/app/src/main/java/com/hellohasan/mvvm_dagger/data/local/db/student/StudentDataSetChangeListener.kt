package com.hellohasan.mvvm_dagger.data.local.db.student

interface StudentDataSetChangeListener {
    fun onStudentDataChanged()
    fun onStudentDataSetChangeError(error: String)
}