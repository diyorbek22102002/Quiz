package com.example.quizapp.db.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.quizapp.data.model.User_SQLite

@Database(entities = [User_SQLite::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun membersDao(): MembersDao
}