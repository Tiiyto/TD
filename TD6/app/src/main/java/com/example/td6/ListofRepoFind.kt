package com.example.td6

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.example.td6.adapter.RepoAdapter
import com.example.td6.models.Repo
import com.example.td6.services.GithubService
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ListofRepoFind : AppCompatActivity() {
    val repos: ArrayList<Repo> = ArrayList()
    lateinit var repoDAO: RepoDao
    lateinit var rvRepos: RecyclerView
    lateinit var githubService: GithubService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listof_repo_find)
        rvRepos = findViewById(R.id.rvRepo)
        rvRepos.adapter = RepoAdapter(repos, this)
        rvRepos.layoutManager = LinearLayoutManager(this)

        val database =
            Room.databaseBuilder(applicationContext, AppDatabase::class.java, "mydb")
                .build()

        repoDAO = database.repoDao()

         githubService = Retrofit.Builder()
            .baseUrl(GithubService.ENDPOINT)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build()
            .create(GithubService::class.java)

        loadRepos()
    }

    fun loadRepos() {
        githubService.searchRepos(intent.getStringExtra("nameRepo"))
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .map {repoList->
                repoDAO.getRepos().flatMapIterable {
                    it
                }.forEach {repo->
                    repoDAO.deleteRepo(repo)
                }

                repoList.items.forEach { repo ->
                        repoDAO.insertOrUpdateRepo(repo)
                    }
                return@map repoList
            }
            .subscribe({ reposList ->
                repos.addAll(reposList.items)
                rvRepos.adapter?.notifyDataSetChanged()
            }, {
                Toast.makeText(this@ListofRepoFind, it.message, Toast.LENGTH_SHORT).show()
            })
    }




}