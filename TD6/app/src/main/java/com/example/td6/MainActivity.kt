package com.example.td6

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.td6.models.Repo
import com.example.td6.services.GithubService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val githubService = Retrofit.Builder()
                .baseUrl(GithubService.ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(GithubService::class.java)
        githubService.listRepos("adrienbusin")?.enqueue(object : Callback<List<Repo>> {
            override fun onResponse(call: Call<List<Repo>>, response: Response<List<Repo>>) {
                afficherRepos(response.body())
            }

            override fun onFailure(call: Call<List<Repo>>, t: Throwable) {
            }
        })
        val find: Button = findViewById(R.id.button)
        val nameRepo: TextView = findViewById(R.id.editTextTextPersonName)
        find.setOnClickListener {
            val Intent = Intent(this, ListofRepoFind::class.java)
            Intent.putExtra("nameRepo", nameRepo.text.toString())
            startActivity(Intent)
        }
        val seeDb: Button = findViewById(R.id.button2)
        seeDb.setOnClickListener {
            val Intent = Intent(this, SeeDatabase::class.java)
            startActivity(Intent)
        }
    }
    fun afficherRepos(repos: List<Repo?>?)
    {
        Toast.makeText(this, "nombre de dépots : " + repos?.size, Toast.LENGTH_SHORT).show()
    }
}