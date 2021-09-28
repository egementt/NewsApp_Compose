package com.example.newsapp_compose

import android.annotation.SuppressLint
import android.app.Application
import android.util.Log
import com.example.newsapp_compose.util.Constants.LOG
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class NewsApplication : Application() {
    @SuppressLint("LogNotTimber")
    override fun onCreate() {
        super.onCreate()
        Log.d(LOG,"Hilt started.")
    }
}