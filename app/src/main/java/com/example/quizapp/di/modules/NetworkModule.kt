package com.example.quizapp.di.modules
import com.example.quizapp.damain.ViewModel.QuizData
import com.example.quizapp.data.network.Build
import org.koin.dsl.module
    val build = Build()
    val quiz = QuizData()

    var networkModule = module {
        single { build.buildRetrofit()}
        single {QuizData()}
//        factory { QuizData() }
//        scope<QuizData> { QuizData() }
    }
