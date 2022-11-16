package com.example.quizapp.db

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.quizapp.data.model.User_SQLife


class DatabaseHelper(val context: Context?) :  SQLiteOpenHelper(context, dbName, null, version) {



    override fun onCreate(db: SQLiteDatabase) {
        try {
            db.execSQL(CREATE_TABLE)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL(DROP_TABLE)
        onCreate(db)
    }

    fun insertMemberOfUserSQLife(member:User_SQLife  ): Boolean {
        val db = this.writableDatabase
        val cv = ContentValues()
        cv.put(CORRECT_ANSWER, member.correct_answer)
        cv.put(DIFFICULTY, member.difficulty)
        val result = db.insert(TABLE_NAME, null, cv)
        return if (result == -1L) false else true
    }
    fun getMembers():ArrayList<User_SQLife>{
        val members = ArrayList<User_SQLife>()
        val db = this.readableDatabase
        val cursor = db.rawQuery( "select * from $TABLE_NAME"  ,null)
        cursor.moveToFirst()
        for (i in 1..cursor.count){
            members.add(User_SQLife(cursor.getInt(1),cursor.getString(2)))
            try {
                cursor.moveToNext()
            }catch (e:Exception){

            }
        }
        return members
    }


    companion object {
        const val version = 3
        var dbName = "Company.db"
        const val TABLE_NAME = "result"
        const val ID = "id"
        const val CORRECT_ANSWER = "correct_answer"
        const val DIFFICULTY = "Difficulty"


        private const val CREATE_TABLE : String =
            "create table if not exists $TABLE_NAME ($ID INTEGER PRIMARY KEY AUTOINCREMENT, $CORRECT_ANSWER INTEGER NOT NULL, $DIFFICULTY TEXT );"
        private const val DROP_TABLE = "DROP TABLE IF EXISTS  $TABLE_NAME"
    }

}


