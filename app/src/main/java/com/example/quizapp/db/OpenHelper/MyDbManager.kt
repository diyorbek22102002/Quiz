//package com.example.quizapp.db
//
//import android.content.ContentValues
//import android.content.Context
//import android.database.sqlite.SQLiteDatabase
//import com.example.quizapp.data.model.User_SQLite
//import com.example.quizapp.db.DatabaseHelper.AMOUNT
//import com.example.quizapp.db.DatabaseHelper.CATEGORY
//import com.example.quizapp.db.DatabaseHelper.CORRECT_ANSWER
//import com.example.quizapp.db.DatabaseHelper.DIFFICULTY
//import com.example.quizapp.db.DatabaseHelper.ID
//import com.example.quizapp.db.DatabaseHelper.TABLE_NAME
//
//class MyDbManager (context: Context) : MydbHelper(context) {
//
//    var db : SQLiteDatabase? = null
//
//    fun insertMember(member: User_SQLite): Boolean {
//        val db = this.writableDatabase
//        val cv = ContentValues()
//        cv.put(CATEGORY, member.category)
//        cv.put(DIFFICULTY,member.difficulty)
//        cv.put(CORRECT_ANSWER, member.correct_answer)
//        cv.put(AMOUNT, member.amount)
//
//        val result = db.insert(TABLE_NAME, null, cv)
//        return if (result == -1L) false else true
//    }
//    fun deleteAllUser(User : User_SQLite) {
//        val db = this.writableDatabase
//        db.delete(TABLE_NAME,null,null)
//    }
//
//        fun getMembers():ArrayList<User_SQLite>{
//        val members = ArrayList<User_SQLite>()
//        val db = this.readableDatabase
//        val cursor = db.rawQuery( "select * from $TABLE_NAME"  ,null)
//        cursor.moveToFirst()
//        cursor.count
//            println(cursor.count)
//        while (!cursor.isAfterLast) {
//            members.add(User_SQLite(cursor.getString(1), cursor.getString(2), cursor.getInt(3),cursor.getInt(4)))
//            cursor.moveToNext()
//        }
//        return members
//    }
//        fun updateUser(id: Int,member:User_SQLite) {
//        val cv = ContentValues()
//        cv.put(CATEGORY, member.category)
//        cv.put(DIFFICULTY,member.difficulty)
//        cv.put(CORRECT_ANSWER, member.correct_answer)
//        cv.put(AMOUNT, member.amount)
//        val db = this.readableDatabase
//        db.update(TABLE_NAME,cv,"$ID=$id",null)
//
//
//    }
//        fun deleteUser(id: Int){
//        val db = this.writableDatabase
//        db.delete(TABLE_NAME,"$ID=$id"  ,null)
//    }
//}