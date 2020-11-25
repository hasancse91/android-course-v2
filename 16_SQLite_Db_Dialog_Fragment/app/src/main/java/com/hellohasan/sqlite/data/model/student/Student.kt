package com.hellohasan.sqlite.data.model.student

data class Student(
    var id: Long = -1L,
    val name: String,
    val registrationNumber: Long,
    val phoneNumber: String,
    val email: String
)