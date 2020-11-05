package com.example.td6.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName


@Entity
data class Repo(
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: Int,
    @ColumnInfo(name = "name")
    val name: String,
    @SerializedName("full_name")
    @ColumnInfo(name = "full_name" )
    val fullName: String,
    @ColumnInfo(name = "html_url")
    val html_url: String
)