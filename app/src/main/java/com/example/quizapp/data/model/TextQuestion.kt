package com.example.quizapp.data.model

data class TextQuestion(
    var category : String,
    var type : String,
    var difficulty : String,
    var question : String,
    var correct_answer : String,
    var incorrect_answers : ArrayList<String>
):java.io.Serializable
