package com.example.td6.services

import com.example.td6.models.Repo
import com.example.td6.models.ReposList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface GithubService {
    companion object
    {
        val ENDPOINT = "https://api.github.com"
    }

    @GET("/users/{user}/repos")
    fun listRepos(@Path("user") user: String?): Call<List<Repo>>

    @GET("/search/repositories")
    fun searchRepos(@Query("q") query: String?): Call<ReposList>
}