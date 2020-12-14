package com.hellohasan.room_orm.data.local.db.student

interface StudentDataSetChangeListener {
    fun onStudentDataChanged()
    fun onStudentDataSetChangeError(error: String)
}