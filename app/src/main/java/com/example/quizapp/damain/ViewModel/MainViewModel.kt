package com.example.quizapp.damain.ViewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.quizapp.data.network.Api
import com.example.quizapp.data.network.CategoryCall
import com.example.quizapp.data.network.ListQuestion
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel( private val api: Api,private val quiz: QuizData) : ViewModel() {

    var categoryName : String = ""
    var amount  : Int = 5
    var category : Int = 9
    var difficulty : String = ""


    val questionLiveData : MutableLiveData<ListQuestion> by lazy {
        MutableLiveData<ListQuestion>()
    }
    val categoryLiveData  : MutableLiveData<CategoryCall> by lazy {
        MutableLiveData<CategoryCall>()
    }



    init {
    getCategory()
    }

     fun getQuestions() {
        val response: Call<ListQuestion> = api.getQuestion(amount,category,difficulty)
        response.enqueue(object : Callback<ListQuestion> {
            override fun onResponse(call: Call<ListQuestion>, response: Response<ListQuestion>) {
                questionLiveData.value = response.body()!!
                quiz.questionQuiz  = response.body()!!
                quiz.amount = amount
                quiz.difficulty = difficulty
                Log.e("QuizViewModel",quiz.questionQuiz.toString())
                Log.e("LIST_QUESTION_VIEW_MODEL",questionLiveData.value.toString())

            }

            override fun onFailure(call: Call<ListQuestion>, t: Throwable) {
                t.printStackTrace()
            }

        })


    }

  private  fun getCategory(){
        val categoryID: Call<CategoryCall> = api.getCategory()
        categoryID.enqueue(object : Callback<CategoryCall>{
            override fun onResponse(call: Call<CategoryCall>, categoruID: Response<CategoryCall>) {
                categoryLiveData.value = categoruID.body()
            }

            override fun onFailure(call: Call<CategoryCall>, t: Throwable) {
                t.printStackTrace()
            }


        })
    }


}