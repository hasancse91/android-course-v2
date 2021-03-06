package com.hellohasan.sqlite.data.model.student

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.SQLException
import com.hellohasan.sqlite.core.DataFetchCallback
import com.hellohasan.sqlite.data.db.DbHelper
import com.hellohasan.sqlite.utils.*
import com.orhanobut.logger.Logger

class StudentModelImpl(private val context: Context) : StudentModel {

    override fun insertStudent(student: Student, callback: DataFetchCallback<Student>) {
        val dbHelper = DbHelper.getInstance(context)
        val sqLiteDatabase = dbHelper.writableDatabase

        val contentValues = ContentValues()
        contentValues.put(COLUMN_STUDENT_NAME, student.name)
        contentValues.put(COLUMN_STUDENT_REGISTRATION, student.registrationNumber)
        contentValues.put(COLUMN_STUDENT_PHONE, student.phoneNumber)
        contentValues.put(COLUMN_STUDENT_EMAIL, student.email)

        try {
            val id = sqLiteDatabase.insertOrThrow(TABLE_STUDENT, null, contentValues)
            if (id > 0) {
                student.id = id
                callback.onSuccess(student)
            } else
                callback.onError(Throwable("Insertion failed for unknown reason"))
        } catch (e: Exception) {
            callback.onError(e)
            Logger.e(e.localizedMessage)
        } finally {
            sqLiteDatabase?.close()
        }
    }

    override fun getStudentList(callback: DataFetchCallback<MutableList<Student>>) {

        val dbHelper = DbHelper.getInstance(context)
        val sqLiteDatabase = dbHelper.readableDatabase

        var cursor: Cursor? = null

        try {

            cursor = sqLiteDatabase.query(
                TABLE_STUDENT,
                null,
                null,
                null,
                null,
                null,
                null,
                null
            )

            /**
             *
             * // If you want to execute raw query then uncomment this code block. And comment above cursor initialization.
             * // The output of both are same.
             *
            val SELECT_QUERY = String.format(
            "SELECT %s, %s, %s, %s, %s FROM %s",
            COLUMN_STUDENT_ID,
            COLUMN_STUDENT_NAME,
            COLUMN_STUDENT_REGISTRATION,
            COLUMN_STUDENT_EMAIL,
            COLUMN_STUDENT_PHONE,
            TABLE_STUDENT
            )
            cursor = sqLiteDatabase.rawQuery(SELECT_QUERY, null)
             */

            if (cursor?.moveToFirst() == true) {

                val studentList = mutableListOf<Student>()

                do {
                    val id = cursor.getInt(0) // the index of _id is 0
                    val name = cursor.getString(cursor.getColumnIndex(COLUMN_STUDENT_NAME))
                    val registrationNumber =
                        cursor.getLong(cursor.getColumnIndex(COLUMN_STUDENT_REGISTRATION))
                    val email = cursor.getString(cursor.getColumnIndex(COLUMN_STUDENT_EMAIL))
                    val phone = cursor.getString(cursor.getColumnIndex(COLUMN_STUDENT_PHONE))

                    studentList.add(Student(id.toLong(), name, registrationNumber, email, phone))

                } while (cursor.moveToNext())

                callback.onSuccess(studentList)
            }

        } catch (e: Exception) {
            callback.onError(e)
            Logger.e(e.localizedMessage)
        } finally {
            cursor?.close()
            sqLiteDatabase?.close()
        }
    }

    override fun updateStudent(student: Student, callback: DataFetchCallback<Int>) {
        val dbHelper = DbHelper.getInstance(context)
        val sqLiteDatabase = dbHelper.writableDatabase

        val contentValues = ContentValues()
        contentValues.put(COLUMN_STUDENT_NAME, student.name)
        contentValues.put(COLUMN_STUDENT_REGISTRATION, student.registrationNumber)
        contentValues.put(COLUMN_STUDENT_PHONE, student.phoneNumber)
        contentValues.put(COLUMN_STUDENT_EMAIL, student.email)

        try {
            val rowCount = sqLiteDatabase.update(
                TABLE_STUDENT,
                contentValues,
                "$COLUMN_STUDENT_ID = ? ",
                arrayOf(student.id.toString())
            )

            if (rowCount > 0) {
                callback.onSuccess(rowCount)
            } else {
                callback.onError(Throwable("No item is updated"))
            }

        } catch (e: Exception) {
            callback.onError(e)
            Logger.e(e.localizedMessage)
        } finally {
            sqLiteDatabase.close()
        }
    }

    /**
     * If deletion process is success, then onSuccess() method will be triggered with `number of deleted row`
     */
    override fun deleteStudent(id: Long, callback: DataFetchCallback<Int>) {
        val dbHelper = DbHelper.getInstance(context)
        val sqLiteDatabase = dbHelper.writableDatabase

        try {
            val deleteRowCount = sqLiteDatabase.delete(
                TABLE_STUDENT,
                "$COLUMN_STUDENT_ID = ? ",
                arrayOf(id.toString())
            )

            if (deleteRowCount > 0) {
                callback.onSuccess(deleteRowCount)
            } else {
                callback.onError(Throwable("No data is deleted"))
            }
        } catch (e: Exception) {
            callback.onError(e)
            Logger.e(e.localizedMessage)
        } finally {
            sqLiteDatabase.close()
        }
    }
}