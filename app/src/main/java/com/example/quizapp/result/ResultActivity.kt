package com.example.quizapp.result

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.quizapp.R
import com.example.quizapp.data.model.Counters
import com.example.quizapp.data.model.TextQuestion
import com.example.quizapp.data.model.User_SQLife
import com.example.quizapp.db.DatabaseHelper
import com.example.quizapp.history.HistoryActivity

class ResultActivity :AppCompatActivity() {
    @SuppressLint("MissingInflatedId", "WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        var counters :Counters= Counters()

        val dbh = DatabaseHelper(this)
        dbh.insertMemberOfUserSQLife(User_SQLife(correct_answer = counters.countTrueAnswers ,  "Easy"))
        Log.e("dbh",dbh.toString())

        if (intent.hasExtra("counters")) {
            counters = intent.getSerializableExtra("counters") as Counters
        }
        var countTrueAnswer =   intent.getIntExtra("cta",0)
        var amount = intent.getIntExtra("amount",5)
        var question_now =findViewById<TextView>(R.id.question_now)
        var question_max = findViewById<TextView>(R.id.question_max)
        var percentnumber =findViewById<TextView>(R.id.percentnumber)
        var finish = findViewById<ImageView>(R.id.finish)
        question_now.text=counters.countTrueAnswers.toString()
        question_max.text=counters.amount.toString()
        percentnumber.text=((counters.countTrueAnswers*100)/counters.amount).toString()

        finish.setOnClickListener{
//            startActivity(Intent(this@ResultActivity,HistoryActivity::class.java))
//            finish()
            Log.e("User",dbh.getMembers().toString())
        }
    }
}