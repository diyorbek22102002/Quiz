package com.example.quizapp.history

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.quizapp.R
import com.example.quizapp.data.model.Result

class HistoryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)
        val results = ArrayList<com.example.quizapp.data.model.Result>()
        results.add(Result("Films","easy",8,10,"Rak ywkyrganda"))
        results.add(Result("Anime","easy",8,10,"Rak ywkyrganda"))
        results.add(Result("Geography","easy",8,10,"Rak ywkyrganda"))
        results.add(Result("Math","easy",8,10,"Rak ywkyrganda"))
        results.add(Result("Physics","easy",8,10,"Rak ywkyrganda"))
        results.add(Result("Sport","easy",8,10,"Rak ywkyrganda"))
        val recyclerView: RecyclerView = findViewById(R.id.rv_history)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = RVHistoryAdapter(results)

    }
}