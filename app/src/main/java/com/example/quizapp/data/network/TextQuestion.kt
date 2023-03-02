package com.example.quizapp.data.network

import java.io.Serializable

data class TextQuestion(
    var category : String,
    var type : String,
    var difficulty : String,
    var question : String,
    var correct_answer : String,
    var incorrect_answers : ArrayList<String>
): Serializable
