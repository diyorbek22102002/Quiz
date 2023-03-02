package com.example.quizapp.data.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Build {
    fun buildRetrofit(): Api {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://opentdb.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val service: Api = retrofit.create(Api::class.java)
        return service
    }
}