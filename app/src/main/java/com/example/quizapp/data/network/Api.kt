package com.example.quizapp.data.network

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {
    @GET("api.php")
    fun getQuestion(
        @Query("amount") amount: Int,
        @Query("category") category: Int,
        @Query("difficulty") difficulty: String,
    ): Call<ListQuestion>

    @GET("api_category.php")
    fun getCategory(
    ): Call<CategoryCall>


}