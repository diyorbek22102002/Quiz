package com.example.quizapp.data.model

import java.io.Serializable
data class Question(

var type     :  String,
var question :  String,
var answers  : ArrayList<String>,
var trueAnswer:Int,
):Serializable

