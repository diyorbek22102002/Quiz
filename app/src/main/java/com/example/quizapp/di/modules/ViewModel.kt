package com.example.quizapp.di.modules
import com.example.quizapp.damain.ViewModel.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

var viewModelModule = module {
    viewModel {MainViewModel(get(),get())}
}