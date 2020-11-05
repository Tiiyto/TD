package com.example.td6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.example.td6.adapter.RepoAdapter
import com.example.td6.models.Repo

class SeeDatabase : AppCompatActivity() {
    lateinit var rvRepos: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_see_database)
        val database = Room.databaseBuilder(this, AppDatabase::class.java, "mydb")
                .allowMainThreadQueries()
                .build()
        val repoDAO: RepoDao = database.repoDao()
        val reposFomDb = repoDAO.getRepos()
        rvRepos = findViewById(R.id.rvRepo2 )
        rvRepos.adapter = RepoAdapter(reposFomDb as ArrayList<Repo>, this)
        rvRepos.layoutManager = LinearLayoutManager(this)
    }
}