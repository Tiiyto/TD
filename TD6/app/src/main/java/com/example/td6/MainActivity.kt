package com.example.td6

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.td6.models.Repo
import com.example.td6.services.GithubService
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
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
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(GithubService::class.java)


        githubService.listRepos("adrienbusin")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({listrepo->
               //Ici vous obtenez vos resultat dans la variable listrepo
                afficherRepos(listrepo)
            }, {error->
                // et ici les erreurs
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

    fun afficherRepos(repos: List<Repo?>?) {
        Toast.makeText(this, "nombre de dépots : " + repos?.size, Toast.LENGTH_SHORT).show()
    }
}