package com.hellohasan.room_orm.data.local

interface StudentDataSetChangeListener {
    fun onStudentDataChanged()
    fun onStudentDataSetChangeError(error: String)
}