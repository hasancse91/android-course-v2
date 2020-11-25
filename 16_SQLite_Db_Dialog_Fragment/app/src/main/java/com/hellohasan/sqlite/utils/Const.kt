package com.hellohasan.sqlite.utils

// If you change the database schema, you must increment the database version.
const val DATABASE_VERSION = 1
const val DATABASE_NAME = "student-db"

//column names of student table
const val TABLE_STUDENT = "student"
const val COLUMN_STUDENT_ID = "_id"
const val COLUMN_STUDENT_NAME = "name"
const val COLUMN_STUDENT_REGISTRATION = "registration_no"
const val COLUMN_STUDENT_PHONE = "phone"
const val COLUMN_STUDENT_EMAIL = "email"

//others for general purpose key-value pair data
const val TITLE = "title"
const val CREATE_STUDENT = "create_student"
const val UPDATE_STUDENT = "update_student"