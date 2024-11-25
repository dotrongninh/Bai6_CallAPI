package com.example.bai6_callapi2.DI

import android.app.Application
import android.util.Log

class ExerciseApplication : Application() {
    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .networkModule(NetworkModule())
            .build()
        Log.d("check","thanh cong")
    }
}