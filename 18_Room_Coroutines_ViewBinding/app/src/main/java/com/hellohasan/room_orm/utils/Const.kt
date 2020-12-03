package com.hellohasan.room_orm.utils

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

//column names of subject table
const val TABLE_SUBJECT = "subject"
const val COLUMN_SUBJECT_ID = "_id"
const val COLUMN_REGISTRATION_NUMBER_FK = "fk_registration_no"
const val COLUMN_SUBJECT_NAME = "name"
const val COLUMN_SUBJECT_CODE = "subject_code"
const val COLUMN_SUBJECT_CREDIT = "credit"
const val STUDENT_SUB_CONSTRAINT = "student_sub_unique"

//others for general purpose key-value pair data
val TITLE: String? = "title"
const val CREATE_STUDENT = "create_student"
const val UPDATE_STUDENT = "update_student"
const val CREATE_SUBJECT = "create_subject"
const val UPDATE_SUBJECT = "update_subject"
const val STUDENT_REGISTRATION = "student_registration"