package com.example.newslist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop

class DetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        setTitle(localClassName)
        val ok: Button = findViewById(R.id.ok)
        val login: TextView = findViewById(R.id.logDetails)
        Glide.with(this)
            .load("https://homepages.cae.wisc.edu/~ece533/images/baboon.png")
            .transform(CircleCrop())
            .into(findViewById<ImageView>(R.id.singe))
        Glide.with(this)
            .load("https://tresorsdeshautsdefrance.com/wp-content/uploads/2020/05/banniere_v2-1-1024x210.jpg")
            .transform(CircleCrop())
            .into(findViewById<ImageView>(R.id.Singe2))
        login.text = NewsListApplication.login
        ok.setOnClickListener{
            finish()
        }
    }
    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}