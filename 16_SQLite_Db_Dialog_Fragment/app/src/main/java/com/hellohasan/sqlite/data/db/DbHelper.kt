package com.hellohasan.sqlite.data.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.hellohasan.sqlite.utils.*

object DbHelper {

    private lateinit var context: Context

    // read this to know about `by lazy{ }`: https://stackoverflow.com/questions/36623177/kotlin-property-initialization-using-by-lazy-vs-lateinit
    private val dbHelper by lazy {

        object : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

            override fun onCreate(db: SQLiteDatabase?) {

                /**
                 * Here, we execute this SQL query:
                 * CREATE TABLE student(_id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT NOT NULL, registration_no INTEGER NOT NULL UNIQUE, phone TEXT, email TEXT )
                 */

                val s = "CREATE TABLE $TABLE_STUDENT($COLUMN_STUDENT_ID INTEGER PRIMARY KEY AUTOINCREMENT, $COLUMN_STUDENT_NAME TEXT NOT NULL, $COLUMN_STUDENT_REGISTRATION INTEGER NOT NULL UNIQUE, $COLUMN_STUDENT_PHONE TEXT, $COLUMN_STUDENT_EMAIL TEXT)"
                db?.execSQL(s)

                                val CREATE_STUDENT_TABLE = ("CREATE TABLE " + TABLE_STUDENT + "("
                        + COLUMN_STUDENT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                        + COLUMN_STUDENT_NAME + " TEXT NOT NULL, "
                        + COLUMN_STUDENT_REGISTRATION + " INTEGER NOT NULL UNIQUE, "
                        + COLUMN_STUDENT_PHONE + " TEXT, " //nullable
                        + COLUMN_STUDENT_EMAIL + " TEXT " + ")")

                db?.execSQL(CREATE_STUDENT_TABLE)
            }

            override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
                // Drop older table if existed
                db?.execSQL("DROP TABLE IF EXISTS $TABLE_STUDENT")

                // Create tables again
                onCreate(db)
            }

        }
    }

    fun getInstance(context: Context): SQLiteOpenHelper {
        DbHelper.context = context
        return dbHelper
    }
}

//                val CREATE_STUDENT_TABLE = ("CREATE TABLE " + TABLE_STUDENT + "("
//                        + COLUMN_STUDENT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
//                        + COLUMN_STUDENT_NAME + " TEXT NOT NULL, "
//                        + COLUMN_STUDENT_REGISTRATION + " INTEGER NOT NULL UNIQUE, "
//                        + COLUMN_STUDENT_PHONE + " TEXT, " //nullable
//                        + COLUMN_STUDENT_EMAIL + " TEXT " + ")")
//
//                db?.execSQL(CREATE_STUDENT_TABLE)