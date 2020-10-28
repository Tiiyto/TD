package com.example.newslist

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.newslist.models.Post
import com.example.newslist.services.PostService
import com.example.newslist.services.ServiceBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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
        details.setOnClickListener{startActivity(Intent(this,DetailsActivity::class.java))}
        logout.setOnClickListener{
            val intentLog = Intent(this,LoginActivity::class.java)
            startActivity(intentLog)
            finish()
        }
        about.setOnClickListener{
            val url = "https://news.google.com/"
            val intentWeb = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intentWeb)
        }
    }
    override fun onResume() { //It's like on create but this function is started when the view it's seen,
        // so if the view is on paused, it can be change the next time you see it
        super.onResume()
        loadPosts()
    }
    override fun onBackPressed() {
        super.onBackPressed()
        moveTaskToBack(true)
    }
    private fun rand(n: Int): Int /*Return an integer between 1 and n*/
    {
        return (1..n).random()
    }
    private fun loadPosts()
    {
        val postService = ServiceBuilder.buildService(PostService::class.java)
        val requestCall = postService.getListPost()
        requestCall.enqueue(object: Callback<List<Post>> {
            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                if(response.isSuccessful)
                {
                    val postList = response.body()
                    val test: TextView = findViewById(R.id.textView)
                    if(postList != null)
                    {
                        val i: Int = rand(postList.size)
                        test.text = postList[i].title
                    }
                }
            }
            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
            }
        })
    }
}