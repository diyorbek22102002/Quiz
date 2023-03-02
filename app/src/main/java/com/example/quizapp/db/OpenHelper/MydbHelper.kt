package com.example.quizapp.db.OpenHelper

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

//open class MydbHelper(val context: Context?) :  SQLiteOpenHelper(context, DatabaseHelper.dbName,
//    null, DatabaseHelper.version) {
//
//    override fun onCreate(db: SQLiteDatabase?) {
//        try {
//            db?.execSQL(DatabaseHelper.CREATE_TABLE)
//        } catch (e: Exception) {
//            e.printStackTrace()
//        }
//
//    }
//
//    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
//        db.execSQL(DatabaseHelper.DROP_TABLE)
//        onCreate(db)
//    }
//
//
//}