package com.example.quizapp.quiz

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import com.example.quizapp.R
import com.example.quizapp.result.ResultActivity

class  QuizActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)
        var number_question = intent.getIntExtra("number",0)
        var countTrueAnswers =intent.getIntExtra("cta",0)
        var countFalseAnswers =intent.getIntExtra("cfa",0)
        Log.e("number_question",number_question.toString())
        Log.e("countTrueAnswers",countTrueAnswers.toString())
        Log.e("countFalseAnswers",countFalseAnswers.toString())
        var amount =intent.getIntExtra("amount",5)
        findViewById<TextView>(R.id.text_1).text=amount.toString()
        var question = arrayListOf("2+2=4","3+1=3","4+5=9","6-2=3","12/2=6","4+8=11","50/10=5","5*5=25","12-5=6","15/3=5")
        var countTrue = arrayListOf("yas","no","yas","no","yas","no","yas","yas","no","yas")
        var ProgressBar=findViewById<ProgressBar>(R.id.ProgressBar)
        var numbernow =findViewById<TextView>(R.id.text_1)
        var numbermax =findViewById<TextView>(R.id.text_2)

        numbernow.text=number_question.toString()
        ProgressBar.progress=number_question
        numbermax.text=amount.toString()



        var yes = findViewById<ImageView>(R.id.yes)
        var no = findViewById<ImageView>(R.id.no)
        var skip =findViewById<ImageView>(R.id.skip)
        var text_question =findViewById<TextView>(R.id.question)
        text_question.text=question[number_question]
        


        yes.setOnClickListener(object :View.OnClickListener{
            override fun onClick(v: View?) {
                if(countTrue[number_question]=="yas"){
                  countTrueAnswers++

                }else{
                    countFalseAnswers++
                }
                if (number_question+1<amount){
                    startNextQuestion(number_question,countTrueAnswers,countFalseAnswers,amount)
                }else{
                    startNextResult(countTrueAnswers,amount,countFalseAnswers)

                }
            }
        })
        no.setOnClickListener(object :View.OnClickListener{
            override fun onClick(v: View?) {
                if(countTrue[number_question]=="no"){
                    countTrueAnswers++
                }else{
                  countFalseAnswers++
                }
                if (number_question+1<amount){
                    startNextQuestion(number_question,countTrueAnswers,countFalseAnswers,amount)
                }else{
                    startNextResult(countTrueAnswers,amount,countFalseAnswers)
                }
            }
        })
        skip.setOnClickListener(object :View.OnClickListener{
            override fun onClick(v: View?) {
              countFalseAnswers++
                if (number_question+1<amount){
                    startNextQuestion(number_question,countTrueAnswers,countFalseAnswers,amount)
                }else{
                    startNextResult(countTrueAnswers,amount,countFalseAnswers)
                }
            }
        })

    }
    private fun startNextQuestion(
        number_question:Int,
        countTrueAnswers:Int,
        countFalseAnswers:Int,
        amount:Int
    ){
        var intent =Intent(this@QuizActivity, QuizActivity::class.java)
        intent.putExtra("number",number_question+1)
        intent.putExtra("cta",countTrueAnswers)
        intent.putExtra("cfa",countFalseAnswers)
        intent.putExtra("amount",amount)
        startActivity(intent)
        finish()
    }
    private fun startNextResult(amount: Int,countTrueAnswers: Int,countFalseAnswers: Int){
        var intent =Intent(this@QuizActivity, ResultActivity::class.java)
        intent.putExtra("cta",countTrueAnswers)
        intent.putExtra("cfa",countFalseAnswers)
        intent.putExtra("amount",amount)
        startActivity(intent)
        finish()

    }

}
