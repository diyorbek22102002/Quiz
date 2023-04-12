package com.example.quizapp.db.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.quizapp.data.model.User_SQLite
import retrofit2.http.DELETE

@Dao
interface MembersDao {
    @Query("SELECT * FROM User_SQLite")
    fun getAll(): List<User_SQLite>


    @Insert
    fun insertAll(vararg User_SQLite: User_SQLite)


    @Delete
    fun delete(User_SQLite: User_SQLite)

}