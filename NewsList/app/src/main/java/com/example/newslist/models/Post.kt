package com.example.newslist.models

data class Post(
    val myUserId: Int,
    val id: Int,
    val title: String,
    val body: String
)