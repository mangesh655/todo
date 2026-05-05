package com.mangesh.movieloading

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MovieLoadingApplication : Application() {

    override fun onCreate() {
        super.onCreate()
    }
}