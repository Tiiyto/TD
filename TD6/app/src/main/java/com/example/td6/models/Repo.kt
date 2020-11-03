package com.example.td6.models

import com.google.gson.annotations.SerializedName

data class Repo(
    val id: Int,
    val name: String,
    @SerializedName("full_name")
    val fullName: String,
    val html_url: String
)