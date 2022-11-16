package com.example.quizapp.main

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AbsSpinner
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ImageView
import android.widget.SeekBar
import android.widget.Spinner
import android.widget.TextView
import androidx.core.view.get
import com.example.quizapp.quiz.QuizChoiceActivity2
import com.example.quizapp.R
import com.example.quizapp.data.model.User_SQLife
import com.example.quizapp.db.DatabaseHelper
import com.example.quizapp.history.HistoryActivity

class MainActivity : AppCompatActivity() {
    @SuppressLint("WrongViewCast")
    lateinit var spinner: Spinner
    lateinit var text_spinner_1 : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        spinner = findViewById<Spinner>(R.id.spinner) as Spinner
        text_spinner_1 = findViewById<TextView>(R.id.text_spinner_1) as TextView

        var options = arrayOf("Игры ","Фильмы","Кино")

        spinner.adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,options)

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                text_spinner_1.text = options.get(p2)
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                text_spinner_1.text = "Please selector"
            }

        }


        var  amount =findViewById<TextView>(R.id.sd_amount)
        var  history =findViewById<ImageView>(R.id.location)
        var sbAmount = findViewById<SeekBar>(R.id.seekbar)
        var start = findViewById<Button>(R.id.start)
        val dbh = DatabaseHelper(this)
        sbAmount.setOnSeekBarChangeListener(object:SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                amount.text=progress.toString()

            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }

        })

         start.setOnClickListener(object :View.OnClickListener{
            override fun onClick(p0: View?) {

                var intent = Intent(this@MainActivity, QuizChoiceActivity2::class.java)
                intent.putExtra("amount",amount.text.toString().toInt())
                intent.putExtra("options",options.toString())
                Log.e("options",options.toString())
                startActivity(intent)
                finish()
            }
        })

        history.setOnClickListener {
            startActivity(Intent(this@MainActivity,HistoryActivity::class.java))
            finish()
//            dbh.getMembers()
//            Log.e("User",dbh.getMembers().toString())
        }



    }
}
