package com.example.quizapp.data.model

data class Result(
    var category:String,
    var difficulty:String,
    var correctAnswers:Int,
    var amount:Int,
    var date:String
):java.io.Serializable
