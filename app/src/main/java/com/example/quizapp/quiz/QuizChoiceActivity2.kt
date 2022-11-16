package com.example.quizapp.quiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.TextView
import com.example.quizapp.R
import com.example.quizapp.data.model.Counters
import com.example.quizapp.questions.QuestionJson
import com.example.quizapp.result.ResultActivity


class QuizChoiceActivity2 : AppCompatActivity() {

       var counters : Counters = Counters()
       var questionJson = QuestionJson().getQuestion()





    override fun onCreate(savedInstanceState: Bundle?) {
        var amount = intent.getIntExtra("amount",5)
        var options = intent.getIntExtra("options",0)
        counters.amount = amount
        Log.e("amount_1", amount.toString())
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_choise2)

        if (intent.hasExtra("counters"))
            counters = intent.getSerializableExtra("counters") as Counters
        Log.e("counters",counters.number_question.toString())


        Log.e("number", counters.number_question.toString())
        Log.e("countTrueAnswers", counters.countTrueAnswers.toString())

        var nowquestion =findViewById<TextView>(R.id.text_1)
        var maxquestion =findViewById<TextView>(R.id.text_2)
        var text_guestion =findViewById<TextView>(R.id.text_question)
        var ProgressBar =findViewById<ProgressBar>(R.id.ProgressBar)
        var Skip =findViewById<Button>(R.id.Skip)
        



            var nowqusetion1 = counters.number_question +1
            maxquestion.text = counters.amount.toString()
            nowquestion.text = nowqusetion1.toString()
            ProgressBar.progress = counters.number_question
            text_guestion.text = questionJson[counters.number_question].question










        Skip.setOnClickListener(object :View.OnClickListener{
            override fun onClick(v: View?) {

                if (counters.number_question + 1 <counters.amount){
                      startNextQuizChoice(counters)
                }else{
                    startNextResultActivity(counters)
                }
            }
        })
       if (questionJson[counters.number_question].type == "Boolean"){
           TrueFolse()
       }else{
           initfour()
       }

    }
    private fun TrueFolse(){
        findViewById<LinearLayout>(R.id.lin_yasno).visibility = View.VISIBLE
        var True = findViewById<ImageView>(R.id.yas)
        var Folse = findViewById<ImageView>(R.id.no)



        True.setOnClickListener(object :View.OnClickListener{
            override fun onClick(v: View?) {
                if(questionJson[counters.number_question].correct_answer == "True" ){
                    counters.countTrueAnswers++
                }
                if (counters.number_question + 1 <counters.amount){
                    startNextQuizChoice(counters)
                }else{
                    startNextResultActivity(counters)

                }
            }
        })
        Folse.setOnClickListener(object :View.OnClickListener{
            override fun onClick(v: View?) {
                if(questionJson[counters.number_question].correct_answer == "False" ){
                    counters.countTrueAnswers++
                }
                if (counters.number_question + 1 < counters.amount){
                    startNextQuizChoice(counters)
                }else{
                    startNextResultActivity(counters)
                }
            }
        })

    }
    private fun initfour(){
        var Answer1 =findViewById<Button>(R.id.Answer1)
        var Answer2 =findViewById<Button>(R.id.Answer2)
        var Answer3 =findViewById<Button>(R.id.Answer3)
        var Answer4 =findViewById<Button>(R.id.Answer4)
        questionJson[counters.number_question].correct_answer
        findViewById<LinearLayout>(R.id.lin_four).visibility = View.VISIBLE

        Answer1.text= questionJson[counters.number_question].correct_answer
        Answer2.text= questionJson[counters.number_question].incorrect_answers[0]
        Answer3.text= questionJson[counters.number_question].incorrect_answers[1]
        Answer4.text= questionJson[counters.number_question].incorrect_answers[2]

        Answer1.setOnClickListener(object :View.OnClickListener{
            override fun onClick(v: View?) {
                if (questionJson[counters.number_question].correct_answer == Answer1.text.toString())
                    counters.countTrueAnswers++

                if (counters.number_question + 1 < counters.amount){

                    startNextQuizChoice(counters)
                }else {
                    startNextResultActivity(counters)
                }
            }
        })
        Answer2.setOnClickListener(object :View.OnClickListener{
            override fun onClick(v: View?) {
                if (questionJson[counters.number_question].correct_answer == Answer2.text.toString())
                    counters.countTrueAnswers++

                if(counters.number_question + 1 < counters.amount){
                    startNextQuizChoice(counters)
                }else{
                    startNextResultActivity(counters)
                }
            }
        })
        Answer3.setOnClickListener(object :View.OnClickListener{
            override fun onClick(v: View?) {
                if (questionJson[counters.number_question].correct_answer == Answer3.text.toString())
                    counters.countTrueAnswers++

                if (counters.number_question + 1 < counters.amount){
                    startNextQuizChoice(counters)
                }else{
                    startNextResultActivity(counters)
                }
            }
        })
        Answer4.setOnClickListener(object :View.OnClickListener{
            override fun onClick(v: View?) {
                if (questionJson[counters.number_question].correct_answer == Answer4.text.toString())
                    counters.countTrueAnswers++

                if(counters.number_question + 1 <counters.amount){
                    startNextQuizChoice(counters)
                }else{
                    startNextResultActivity(counters)
                }
            }
        })
    }
    private fun amount(amount:Int){
        var intent = Intent(this@QuizChoiceActivity2,QuizChoiceActivity2::class.java)
        intent.putExtra("amount",amount.toString())
        startActivity(intent)
        finish()
    }
    private fun startNextQuizChoice(counters: Counters,
    ){
        var intent =Intent(this@QuizChoiceActivity2, QuizChoiceActivity2::class.java)
        counters.number_question = counters.number_question+1
        intent.putExtra("counters",counters)
        startActivity(intent)
        finish()
    }
    private fun startNextResultActivity(counters: Counters){
        var intent =Intent(this@QuizChoiceActivity2, ResultActivity::class.java)
        intent.putExtra("counters",counters)
        startActivity(intent)
        finish()
    }





}




