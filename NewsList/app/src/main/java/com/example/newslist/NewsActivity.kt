package com.example.newslist

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class NewsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)
        setTitle(localClassName)
        val details: Button = findViewById(R.id.details)
        val logout: Button = findViewById(R.id.logout)
        val about: Button = findViewById(R.id.about)
        val intent = intent
        val logindisplayed: TextView = findViewById(R.id.loginDisplayed)
        if (intent.hasExtra("login"))
        {
            val login = intent.getStringExtra("login")
                logindisplayed.text = login

        }
        details.setOnClickListener{
            val Intent = Intent(this,DetailsActivity::class.java)
            startActivity(Intent)
        }
        logout.setOnClickListener{
            val Intent = Intent(this,LoginActivity::class.java)
            startActivity(Intent)
            finish()
        }
        about.setOnClickListener{
            val url = "https://news.google.com/"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        moveTaskToBack(true)
    }
}