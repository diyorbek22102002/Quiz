package com.example.quizapp.history

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.quizapp.R
import com.example.quizapp.data.model.User_SQLite

class RVHistoryAdapter(var result: List<User_SQLite>): RecyclerView
.Adapter<RVHistoryAdapter.MyViewHolder>() {

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val category: TextView = itemView.findViewById(R.id.category)
        val countTrueAnswer : TextView = itemView.findViewById(R.id.correct_answers)
        val difficult : TextView  = itemView.findViewById(R.id.difficul_1)
        val amount : TextView  = itemView.findViewById(R.id.amount_1)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_history, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.category.text = result[position].category
        holder.countTrueAnswer.text = result[position].correct_answer.toString()
        holder.difficult.text = result[position].difficulty
        holder.amount.text = result[position].amount.toString()



    }

    override fun getItemCount() = result.size

}


