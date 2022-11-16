package com.example.quizapp.questions

import com.example.quizapp.data.model.Question
class CountTrueAnswer() {


  fun main():ArrayList<Question> {
    var questions = ArrayList<Question>()
    questions.add(Question("four", "6+2=?", arrayListOf("1", "2", "8", "3"), 3))
    questions.add(Question("yasno", "2+2=4", arrayListOf(), 1))
    questions.add(Question("four", "10-3?", arrayListOf("2", "7", "6", "5"), 2))
    questions.add(Question("yasno", "3+1=3", arrayListOf(), 0))
    questions.add(Question("four", "4+4?", arrayListOf("2", "7", "8", "5"), 3))
    questions.add(Question("yasno", "4+5=9", arrayListOf(), 1))
    questions.add(Question("four", "3+6?", arrayListOf("2", "7", "6", "9"), 4))
    questions.add(Question("yasno", "6-2=3", arrayListOf(), 0))
    questions.add(Question("four", "12+2?", arrayListOf("14", "7", "6", "5"), 1))
    questions.add(Question("yasno", "12/2=6", arrayListOf(), 1))
    questions.add(Question("four", "7-7?", arrayListOf("2", "7", "0", "5"), 3))
    return questions
  }
}




