package com.example.td6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.example.td6.adapter.RepoAdapter
import com.example.td6.models.Repo
import com.example.td6.models.ReposList
import com.example.td6.services.GithubService
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ListofRepoFind : AppCompatActivity() {
    val repos: ArrayList<Repo> = ArrayList()
    lateinit var rvRepos: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listof_repo_find)
        rvRepos = findViewById(R.id.rvRepo)
        rvRepos.adapter = RepoAdapter(repos, this)
        rvRepos.layoutManager = LinearLayoutManager(this)
        loadRepos()
    }
    fun loadRepos()
    {
        val githubService = Retrofit.Builder()
            .baseUrl(GithubService.ENDPOINT)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(GithubService::class.java)
        githubService.searchRepos(intent.getStringExtra("nameRepo")).enqueue(
            object : Callback<ReposList>{
                override fun onResponse(call: Call<ReposList>, response: Response<ReposList>) {
                    if (response.isSuccessful) {

                        val reposList = response.body()
                        repos.clear()
                        val database = Room.databaseBuilder(this@ListofRepoFind, AppDatabase::class.java, "mydb")
                                .allowMainThreadQueries()
                                .build()
                        val repoDAO: RepoDao = database.repoDao()
                        val reposFomDb = repoDAO.getRepos()
                        for (repo in reposFomDb)
                        {
                            repoDAO.deleteRepo(repo)
                        }

                        if (reposList != null) {
                            repos.addAll(reposList.items)
                            rvRepos.adapter?.notifyDataSetChanged()
                            for(repo in reposList.items)
                            {
                                repoDAO.insertOrUpdateRepo(repo)
                            }
                        }
                    }
                }

                override fun onFailure(call: Call<ReposList>, t: Throwable) {
                    Toast.makeText(this@ListofRepoFind,"Erreur",Toast.LENGTH_SHORT).show()
                }
            }
        )
    }
}