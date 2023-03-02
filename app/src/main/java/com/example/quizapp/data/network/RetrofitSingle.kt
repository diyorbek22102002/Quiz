package com.example.quizapp.data.network
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
class RetrofitSingle {
    @Volatile private var INSTANCE: Api? = null
    val build = Build()
    fun getInstance(): Api = INSTANCE ?: synchronized(this) {
        INSTANCE ?: build.buildRetrofit().also { INSTANCE = it }
      }
  }
