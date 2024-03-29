package com.example.quizapp

import android.app.Application
import com.example.quizapp.di.modules.networkModule
import com.example.quizapp.di.modules.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin

class App: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@App)
            modules(viewModelModule, networkModule)
        }
    }
}