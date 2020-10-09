package com.example.newslist
import android.app.Application

class NewsListApplication : Application() {
    companion object {
        var login: String? = null
    }

    override fun onCreate() {
        super.onCreate()
        login = null
    }
}