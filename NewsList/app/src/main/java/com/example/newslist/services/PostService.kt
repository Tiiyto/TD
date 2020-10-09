package com.example.newslist.services

import com.example.newslist.models.Post
import retrofit2.Call
import retrofit2.http.GET

interface PostService {
    @GET("posts")
    fun getListPost(): Call<List<Post>>
}