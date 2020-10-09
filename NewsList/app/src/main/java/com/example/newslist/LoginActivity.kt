package com.example.newslist

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        setTitle(localClassName)
        val login: Button = findViewById(R.id.login)
        val log: EditText = findViewById(R.id.log)
        login.setOnClickListener{
            val Intent = Intent(this,NewsActivity::class.java)
            NewsListApplication.login = log.text.toString()
            Intent.putExtra("login",log.text.toString())
            startActivity(Intent)
            finish()
        }
    }

}