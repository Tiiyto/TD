package com.example.newslist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.example.newslist.models.Post
import com.example.newslist.services.PostService
import com.example.newslist.services.ServiceBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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
            .load("https://homepages.cae.wisc.edu/~ece533/images/baboon.png")
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