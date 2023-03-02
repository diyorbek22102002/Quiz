package com.example.quizapp.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "User_SQLite")
data class User_SQLite(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    var category: String,
    var difficulty: String,
    var correct_answer: Int,
    var amount: Int,
    ): Serializable


